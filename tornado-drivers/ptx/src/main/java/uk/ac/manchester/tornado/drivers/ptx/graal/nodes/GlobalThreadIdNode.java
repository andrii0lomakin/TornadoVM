/*
 * Copyright (c) 2020, APT Group, Department of Computer Science,
 * School of Engineering, The University of Manchester. All rights reserved.
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

package uk.ac.manchester.tornado.drivers.ptx.graal.nodes;

import static uk.ac.manchester.tornado.drivers.ptx.graal.asm.PTXAssembler.PTXTernaryOp;

import jdk.graal.compiler.core.common.LIRKind;
import jdk.graal.compiler.core.common.type.StampFactory;
import jdk.graal.compiler.graph.NodeClass;
import jdk.graal.compiler.lir.ConstantValue;
import jdk.graal.compiler.lir.Variable;
import jdk.graal.compiler.lir.gen.LIRGeneratorTool;
import jdk.graal.compiler.nodeinfo.NodeInfo;
import jdk.graal.compiler.nodes.ConstantNode;
import jdk.graal.compiler.nodes.calc.FloatingNode;
import jdk.graal.compiler.nodes.spi.LIRLowerable;
import jdk.graal.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.meta.JavaKind;
import uk.ac.manchester.tornado.drivers.common.logging.Logger;
import uk.ac.manchester.tornado.drivers.ptx.graal.PTXArchitecture.PTXBuiltInRegisterArray;
import uk.ac.manchester.tornado.drivers.ptx.graal.compiler.PTXNodeLIRBuilder;
import uk.ac.manchester.tornado.drivers.ptx.graal.lir.PTXLIRStmt;
import uk.ac.manchester.tornado.drivers.ptx.graal.lir.PTXTernary;
import uk.ac.manchester.tornado.runtime.graal.nodes.interfaces.MarkGlobalThreadID;

@NodeInfo
public class GlobalThreadIdNode extends FloatingNode implements LIRLowerable, MarkGlobalThreadID {
    public static final NodeClass<GlobalThreadIdNode> TYPE = NodeClass.create(GlobalThreadIdNode.class);

    @Input
    protected ConstantNode index;

    public GlobalThreadIdNode(ConstantNode value) {
        super(TYPE, StampFactory.forKind(JavaKind.Int));
        assert stamp != null;
        index = value;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        Logger.traceBuildLIR(Logger.BACKEND.PTX, "emitGlobalThreadId: dim=%s", index);
        LIRGeneratorTool tool = gen.getLIRGeneratorTool();
        LIRKind kind = tool.getLIRKind(stamp);
        PTXNodeLIRBuilder ptxNodeBuilder = (PTXNodeLIRBuilder) gen;

        PTXBuiltInRegisterArray builtIns = new PTXBuiltInRegisterArray(((ConstantValue) gen.operand(index)).getJavaConstant().asInt());
        Variable threadID = ptxNodeBuilder.getBuiltInAllocation(builtIns.threadID);
        Variable blockDim = ptxNodeBuilder.getBuiltInAllocation(builtIns.blockDim);
        Variable blockID = ptxNodeBuilder.getBuiltInAllocation(builtIns.blockID);
        Variable result = tool.newVariable(kind);

        tool.append(new PTXLIRStmt.AssignStmt(result, new PTXTernary.Expr(PTXTernaryOp.MAD_LO, kind, blockID, blockDim, threadID)));
        gen.setResult(this, result);
    }
}
