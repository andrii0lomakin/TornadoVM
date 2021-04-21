package uk.ac.manchester.spirvproto.lib.instructions;

import uk.ac.manchester.spirvproto.lib.disassembler.SPIRVPrintingOptions;
import uk.ac.manchester.spirvproto.lib.instructions.operands.*;

import javax.annotation.Generated;
import java.io.PrintStream;
import java.nio.ByteBuffer;

@Generated("beehive-lab.spirv-proto.generator")
public class SPIRVOpAtomicCompareExchangeWeak extends SPIRVInstruction {
    public final SPIRVId _idResultType;
    public final SPIRVId _idResult;
    public final SPIRVId _pointer;
    public final SPIRVId _scope;
    public final SPIRVId _equal;
    public final SPIRVId _unequal;
    public final SPIRVId _value;
    public final SPIRVId _comparator;

    public SPIRVOpAtomicCompareExchangeWeak(SPIRVId _idResultType, SPIRVId _idResult, SPIRVId _pointer, SPIRVId _scope, SPIRVId _equal, SPIRVId _unequal, SPIRVId _value, SPIRVId _comparator) {
        super(231, _idResultType.getWordCount() + _idResult.getWordCount() + _pointer.getWordCount() + _scope.getWordCount() + _equal.getWordCount() + _unequal.getWordCount() + _value.getWordCount() + _comparator.getWordCount() + 1, "OpAtomicCompareExchangeWeak", SPIRVCapability.Kernel());
        this._idResultType = _idResultType;
        this._idResult = _idResult;
        this._pointer = _pointer;
        this._scope = _scope;
        this._equal = _equal;
        this._unequal = _unequal;
        this._value = _value;
        this._comparator = _comparator;
    }

    @Override
    protected void writeOperands(ByteBuffer output) {
        _idResultType.write(output);
        _idResult.write(output);
        _pointer.write(output);
        _scope.write(output);
        _equal.write(output);
        _unequal.write(output);
        _value.write(output);
        _comparator.write(output);
    }

    @Override
    protected void printOperands(PrintStream output, SPIRVPrintingOptions options) {
         
        _idResultType.print(output, options);
        output.print(" ");
  
        _pointer.print(output, options);
        output.print(" ");
 
        _scope.print(output, options);
        output.print(" ");
 
        _equal.print(output, options);
        output.print(" ");
 
        _unequal.print(output, options);
        output.print(" ");
 
        _value.print(output, options);
        output.print(" ");
 
        _comparator.print(output, options);
    }

    @Override
    public SPIRVId getResultId() {
        return _idResult;
    }

    @Override
    public SPIRVCapability[] getAllCapabilities() {
        SPIRVCapability[] allCapabilities = new SPIRVCapability[this.capabilities.length + _idResultType.getCapabilities().length + _idResult.getCapabilities().length + _pointer.getCapabilities().length + _scope.getCapabilities().length + _equal.getCapabilities().length + _unequal.getCapabilities().length + _value.getCapabilities().length + _comparator.getCapabilities().length];
        int capPos = 0;
        for (SPIRVCapability capability : this.capabilities) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _idResultType.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _idResult.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _pointer.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _scope.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _equal.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _unequal.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _value.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _comparator.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }

        return allCapabilities;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SPIRVOpAtomicCompareExchangeWeak) {
            SPIRVOpAtomicCompareExchangeWeak otherInst = (SPIRVOpAtomicCompareExchangeWeak) other;
            if (!this._idResultType.equals(otherInst._idResultType)) return false;
            if (!this._pointer.equals(otherInst._pointer)) return false;
            if (!this._scope.equals(otherInst._scope)) return false;
            if (!this._equal.equals(otherInst._equal)) return false;
            if (!this._unequal.equals(otherInst._unequal)) return false;
            if (!this._value.equals(otherInst._value)) return false;
            if (!this._comparator.equals(otherInst._comparator)) return false;
            return true;
        }
        else return super.equals(other);
    }
}
