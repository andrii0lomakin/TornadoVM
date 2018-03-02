/*
 * Copyright (c) 2018, APT Group, School of Computer Science,
 * The University of Manchester. All rights reserved.
 * Copyright (c) 2009, 2017, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Authors: James Clarkson
 *
 */
package uk.ac.manchester.tornado.graal.phases;

import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.phases.BasePhase;
import java.util.Collections;
import java.util.List;

import uk.ac.manchester.tornado.common.Tornado;
import uk.ac.manchester.tornado.graal.nodes.ParallelRangeNode;
import uk.ac.manchester.tornado.meta.domain.DomainTree;
import uk.ac.manchester.tornado.meta.domain.IntDomain;

public class TornadoShapeAnalysis extends BasePhase<TornadoHighTierContext> {

    private static final int resolveInt(ValueNode value) {
        if (value instanceof ConstantNode) {
            return ((ConstantNode) value).asJavaConstant().asInt();
        } else {
            //TornadoInternalError.shouldNotReachHere();
            return Integer.MIN_VALUE;
        }
    }

    @Override
    protected void run(StructuredGraph graph, TornadoHighTierContext context) {

        if (!context.hasMeta()) {
            return;
        }

        final List<ParallelRangeNode> ranges = graph.getNodes().filter(ParallelRangeNode.class).snapshot();

        Collections.sort(ranges);

        final DomainTree domainTree = new DomainTree(ranges.size());

        int lastIndex = -1;
        boolean valid = true;
        for (int i = 0; i < ranges.size(); i++) {
            final ParallelRangeNode range = ranges.get(i);
            final int index = range.index();
            if (index != lastIndex && resolveInt(range.offset().value()) != Integer.MIN_VALUE && resolveInt(range.stride().value()) != Integer.MIN_VALUE && resolveInt(range.value()) != Integer.MIN_VALUE) {
                domainTree.set(index, new IntDomain(resolveInt(range.offset().value()), resolveInt(range.stride().value()), resolveInt(range.value())));
            } else {
                valid = false;
                Tornado.info("unsupported multiple parallel loops");
                break;
            }
            lastIndex = index;
        }

        if (valid) {
            Tornado.trace("loop nest depth = %d", domainTree.getDepth());

            Tornado.debug("discovered parallel domain: %s", domainTree);

            context.getMeta().setDomain(domainTree);
        }

    }

}