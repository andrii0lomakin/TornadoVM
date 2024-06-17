/*
 * Copyright (c) 2024, APT Group, Department of Computer Science,
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
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */
package uk.ac.manchester.tornado.drivers.ptx.graal.phases;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaType;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.GraphState;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValuePhiNode;
import org.graalvm.compiler.nodes.memory.ReadNode;
import org.graalvm.compiler.nodes.memory.address.OffsetAddressNode;
import org.graalvm.compiler.phases.Phase;

import uk.ac.manchester.tornado.drivers.ptx.graal.PTXArchitecture;
import uk.ac.manchester.tornado.drivers.ptx.graal.nodes.FixedArrayCopyNode;
import uk.ac.manchester.tornado.drivers.ptx.graal.nodes.FixedArrayNode;

import java.util.Optional;

/**
 * This phase examines if a copy takes place between two arrays in private memory based on
 * an if condition and, if so, inserts a {@link FixedArrayCopyNode} to generate an update in the references.
 */
public class TornadoFixedArrayCopyPhase extends Phase {

    @Override
    public Optional<NotApplicable> notApplicableTo(GraphState graphState) {
        return ALWAYS_APPLICABLE;
    }

    protected void run(StructuredGraph graph) {
        ValuePhiNode phiNodeToReplace = null;
        for (ValuePhiNode phiNode : graph.getNodes().filter(ValuePhiNode.class)) {
            if (phiNode.usages().filter(OffsetAddressNode.class).isNotEmpty() && phiNode.values().filter(FixedArrayNode.class).isNotEmpty()) {
                FixedArrayNode fixedArrayNode = phiNode.values().filter(FixedArrayNode.class).first();
                ResolvedJavaType resolvedJavaType = fixedArrayNode.getElementType();
                PTXArchitecture.PTXMemoryBase oclMemoryBase = fixedArrayNode.getMemoryRegister();
                OffsetAddressNode offsetAddressNode = phiNode.usages().filter(OffsetAddressNode.class).first();
                // finally, since we know that the data accessed is a fixed array, fix the offset
                ValuePhiNode privateIndex = getPrivateArrayIndex(offsetAddressNode.getOffset());
//                Constant offset = new RawConstant(4);
//                ConstantNode offsetNode = new ConstantNode(offset, StampFactory.forKind(JavaKind.Int));
//                graph.addWithoutUnique(offsetNode);
//                MulNode mulNode = new MulNode(privateIndex, offsetNode);
//                graph.addWithoutUnique(mulNode);
                FixedArrayCopyNode fixedArrayCopyNode = new FixedArrayCopyNode(phiNode, resolvedJavaType, oclMemoryBase, privateIndex);
                graph.addWithoutUnique(fixedArrayCopyNode);
                offsetAddressNode.replaceFirstInput(phiNode, fixedArrayCopyNode);
                if (offsetAddressNode.usages().filter(ReadNode.class).isNotEmpty()) {
                    ReadNode readNode = offsetAddressNode.usages().filter(ReadNode.class).first();
                    readNode.replaceAtUsages(fixedArrayCopyNode);
                    deleteFixed(readNode);
                    offsetAddressNode.safeDelete();
                }
                phiNodeToReplace = phiNode;
                break;
            }
        }
        if (phiNodeToReplace != null) {
            ValuePhiNode newPhiNode = new ValuePhiNode(StampFactory.forKind(JavaKind.Int), phiNodeToReplace.merge(), phiNodeToReplace.valueAt(0), phiNodeToReplace.valueAt(1));
            graph.addWithoutUnique(newPhiNode);
            phiNodeToReplace.replaceAtUsages(newPhiNode);
            phiNodeToReplace.safeDelete();
        }
    }

    private static void deleteFixed(Node n) {
        Node pred = n.predecessor();
        Node suc = n.successors().first();

        n.replaceFirstSuccessor(suc, null);
        n.replaceAtPredecessor(suc);
        pred.replaceFirstSuccessor(n, suc);

        for (Node us : n.usages()) {
            n.removeUsage(us);
        }
        n.clearInputs();

        n.safeDelete();
    }

    private static ValuePhiNode getPrivateArrayIndex(Node node) {
        // identify the index
        for (Node input : node.inputs()) {
            if (input instanceof ValuePhiNode phiNode) {
                return phiNode;
            } else {
                return getPrivateArrayIndex(input);
            }
        }
        return null;
    }

}
