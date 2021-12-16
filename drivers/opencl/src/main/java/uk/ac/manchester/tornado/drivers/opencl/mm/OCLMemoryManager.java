/*
 * This file is part of Tornado: A heterogeneous programming framework: 
 * https://github.com/beehive-lab/tornadovm
 *
 * Copyright (c) 2013-2020, APT Group, Department of Computer Science,
 * The University of Manchester. All rights reserved.
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
 */
package uk.ac.manchester.tornado.drivers.opencl.mm;

import uk.ac.manchester.tornado.api.exceptions.TornadoRuntimeException;
import uk.ac.manchester.tornado.api.mm.ObjectBuffer;
import uk.ac.manchester.tornado.api.mm.TornadoMemoryProvider;
import uk.ac.manchester.tornado.drivers.opencl.OCLDeviceContext;
import uk.ac.manchester.tornado.drivers.opencl.enums.OCLMemFlags;
import uk.ac.manchester.tornado.runtime.common.TornadoLogger;

import static uk.ac.manchester.tornado.runtime.common.TornadoOptions.OCL_CALL_STACK_LIMIT;

public class OCLMemoryManager extends TornadoLogger implements TornadoMemoryProvider {

    private long callStackBufferId;
    private final long callStackLimit;
    private long callStackPosition;

    private final OCLDeviceContext deviceContext;
    private long constantPointer;
    private long atomicsRegion = -1;

    private static final int STACK_ALIGNMENT_SIZE = 128;

    private static final int MAX_NUMBER_OF_ATOMICS_PER_KERNEL = 128;
    private static final int INTEGER_BYTES_SIZE = 4;

    public OCLMemoryManager(final OCLDeviceContext deviceContext) {
        this.deviceContext = deviceContext;
        this.callStackPosition = 0;
        this.callStackLimit = OCL_CALL_STACK_LIMIT;
        this.callStackBufferId = deviceContext.getPlatformContext().createBuffer(OCLMemFlags.CL_MEM_READ_WRITE, callStackLimit);
    }

    @Override
    public long getHeapSize() {
        // TODO query for actual device memory size
        return deviceContext.getDevice().getDeviceMaxAllocationSize() * 4;
    }

    private static long align(final long address, final long alignment) {
        return (address % alignment == 0) ? address : address + (alignment - address % alignment);
    }

    public OCLCallStack createCallStack(final int maxArgs) {

        OCLCallStack callStack = new OCLCallStack(callStackBufferId, callStackPosition, maxArgs, deviceContext);

        if (callStackPosition + callStack.getSize() < callStackLimit) {
            callStackPosition = align(callStackPosition + callStack.getSize(), STACK_ALIGNMENT_SIZE);
        } else {
            throw new TornadoRuntimeException("Out of call-stack memory !");
        }

        return callStack;
    }

    public ObjectBuffer createAtomicsBuffer(final int[] arr) {
        return new AtomicsBuffer(arr, deviceContext);
    }

    /**
     * Allocate regions on the device.
     */
    public void allocateDeviceMemoryRegions() {
        this.constantPointer = createBuffer(OCLMemFlags.CL_MEM_READ_WRITE | OCLMemFlags.CL_MEM_ALLOC_HOST_PTR, 4);
        allocateAtomicRegion();
    }

    public long createBuffer(long size, long flags) {
        return deviceContext.getPlatformContext().createBuffer(flags, size);
    }

    public void releaseBuffer(long bufferId) {
        deviceContext.getPlatformContext().releaseBuffer(bufferId);
    }

    long toConstantAddress() {
        return constantPointer;
    }

    long toAtomicAddress() {
        return atomicsRegion;
    }

    void allocateAtomicRegion() {
        if (this.atomicsRegion == -1) {
            this.atomicsRegion = deviceContext.getPlatformContext().createBuffer(OCLMemFlags.CL_MEM_READ_WRITE | OCLMemFlags.CL_MEM_ALLOC_HOST_PTR,
                    INTEGER_BYTES_SIZE * MAX_NUMBER_OF_ATOMICS_PER_KERNEL);
        }
    }

    void deallocateAtomicRegion() {
        if (this.atomicsRegion != -1) {
            deviceContext.getPlatformContext().releaseBuffer(this.atomicsRegion);
            this.atomicsRegion = -1;
        }
    }
}
