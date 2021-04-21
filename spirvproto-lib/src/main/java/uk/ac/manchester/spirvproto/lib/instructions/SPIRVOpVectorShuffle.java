package uk.ac.manchester.spirvproto.lib.instructions;

import uk.ac.manchester.spirvproto.lib.disassembler.SPIRVPrintingOptions;
import uk.ac.manchester.spirvproto.lib.instructions.operands.*;

import javax.annotation.Generated;
import java.io.PrintStream;
import java.nio.ByteBuffer;

@Generated("beehive-lab.spirv-proto.generator")
public class SPIRVOpVectorShuffle extends SPIRVInstruction {
    public final SPIRVId _idResultType;
    public final SPIRVId _idResult;
    public final SPIRVId _vector1;
    public final SPIRVId _vector2;
    public final SPIRVMultipleOperands<SPIRVLiteralInteger> _components;

    public SPIRVOpVectorShuffle(SPIRVId _idResultType, SPIRVId _idResult, SPIRVId _vector1, SPIRVId _vector2, SPIRVMultipleOperands<SPIRVLiteralInteger> _components) {
        super(79, _idResultType.getWordCount() + _idResult.getWordCount() + _vector1.getWordCount() + _vector2.getWordCount() + _components.getWordCount() + 1, "OpVectorShuffle");
        this._idResultType = _idResultType;
        this._idResult = _idResult;
        this._vector1 = _vector1;
        this._vector2 = _vector2;
        this._components = _components;
    }

    @Override
    protected void writeOperands(ByteBuffer output) {
        _idResultType.write(output);
        _idResult.write(output);
        _vector1.write(output);
        _vector2.write(output);
        _components.write(output);
    }

    @Override
    protected void printOperands(PrintStream output, SPIRVPrintingOptions options) {
         
        _idResultType.print(output, options);
        output.print(" ");
  
        _vector1.print(output, options);
        output.print(" ");
 
        _vector2.print(output, options);
        output.print(" ");
 
        _components.print(output, options);
    }

    @Override
    public SPIRVId getResultId() {
        return _idResult;
    }

    @Override
    public SPIRVCapability[] getAllCapabilities() {
        SPIRVCapability[] allCapabilities = new SPIRVCapability[this.capabilities.length + _idResultType.getCapabilities().length + _idResult.getCapabilities().length + _vector1.getCapabilities().length + _vector2.getCapabilities().length + _components.getCapabilities().length];
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
        for (SPIRVCapability capability : _vector1.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _vector2.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _components.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }

        return allCapabilities;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SPIRVOpVectorShuffle) {
            SPIRVOpVectorShuffle otherInst = (SPIRVOpVectorShuffle) other;
            if (!this._idResultType.equals(otherInst._idResultType)) return false;
            if (!this._vector1.equals(otherInst._vector1)) return false;
            if (!this._vector2.equals(otherInst._vector2)) return false;
            if (!this._components.equals(otherInst._components)) return false;
            return true;
        }
        else return super.equals(other);
    }
}
