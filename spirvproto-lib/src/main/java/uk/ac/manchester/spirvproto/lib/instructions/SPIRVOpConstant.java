package uk.ac.manchester.spirvproto.lib.instructions;

import uk.ac.manchester.spirvproto.lib.disassembler.SPIRVPrintingOptions;
import uk.ac.manchester.spirvproto.lib.instructions.operands.*;

import javax.annotation.Generated;
import java.io.PrintStream;
import java.nio.ByteBuffer;

@Generated("beehive-lab.spirv-proto.generator")
public class SPIRVOpConstant extends SPIRVGlobalInst {
    public final SPIRVId _idResultType;
    public final SPIRVId _idResult;
    public final SPIRVLiteralContextDependentNumber _value;

    public SPIRVOpConstant(SPIRVId _idResultType, SPIRVId _idResult, SPIRVLiteralContextDependentNumber _value) {
        super(43, _idResultType.getWordCount() + _idResult.getWordCount() + _value.getWordCount() + 1, "OpConstant");
        this._idResultType = _idResultType;
        this._idResult = _idResult;
        this._value = _value;
    }

    @Override
    protected void writeOperands(ByteBuffer output) {
        _idResultType.write(output);
        _idResult.write(output);
        _value.write(output);
    }

    @Override
    protected void printOperands(PrintStream output, SPIRVPrintingOptions options) {
         
        _idResultType.print(output, options);
        output.print(" ");
  
        _value.print(output, options);
    }

    @Override
    public SPIRVId getResultId() {
        return _idResult;
    }

    @Override
    public SPIRVCapability[] getAllCapabilities() {
        SPIRVCapability[] allCapabilities = new SPIRVCapability[this.capabilities.length + _idResultType.getCapabilities().length + _idResult.getCapabilities().length + _value.getCapabilities().length];
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
        for (SPIRVCapability capability : _value.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }

        return allCapabilities;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SPIRVOpConstant) {
            SPIRVOpConstant otherInst = (SPIRVOpConstant) other;
            if (!this._idResultType.equals(otherInst._idResultType)) return false;
            if (!this._value.equals(otherInst._value)) return false;
            return true;
        }
        else return super.equals(other);
    }
}
