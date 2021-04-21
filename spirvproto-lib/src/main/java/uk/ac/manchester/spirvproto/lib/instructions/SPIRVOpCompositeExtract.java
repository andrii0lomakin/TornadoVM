package uk.ac.manchester.spirvproto.lib.instructions;

import uk.ac.manchester.spirvproto.lib.disassembler.SPIRVPrintingOptions;
import uk.ac.manchester.spirvproto.lib.instructions.operands.*;

import javax.annotation.Generated;
import java.io.PrintStream;
import java.nio.ByteBuffer;

@Generated("beehive-lab.spirv-proto.generator")
public class SPIRVOpCompositeExtract extends SPIRVInstruction {
    public final SPIRVId _idResultType;
    public final SPIRVId _idResult;
    public final SPIRVId _composite;
    public final SPIRVMultipleOperands<SPIRVLiteralInteger> _indexes;

    public SPIRVOpCompositeExtract(SPIRVId _idResultType, SPIRVId _idResult, SPIRVId _composite, SPIRVMultipleOperands<SPIRVLiteralInteger> _indexes) {
        super(81, _idResultType.getWordCount() + _idResult.getWordCount() + _composite.getWordCount() + _indexes.getWordCount() + 1, "OpCompositeExtract");
        this._idResultType = _idResultType;
        this._idResult = _idResult;
        this._composite = _composite;
        this._indexes = _indexes;
    }

    @Override
    protected void writeOperands(ByteBuffer output) {
        _idResultType.write(output);
        _idResult.write(output);
        _composite.write(output);
        _indexes.write(output);
    }

    @Override
    protected void printOperands(PrintStream output, SPIRVPrintingOptions options) {
         
        _idResultType.print(output, options);
        output.print(" ");
  
        _composite.print(output, options);
        output.print(" ");
 
        _indexes.print(output, options);
    }

    @Override
    public SPIRVId getResultId() {
        return _idResult;
    }

    @Override
    public SPIRVCapability[] getAllCapabilities() {
        SPIRVCapability[] allCapabilities = new SPIRVCapability[this.capabilities.length + _idResultType.getCapabilities().length + _idResult.getCapabilities().length + _composite.getCapabilities().length + _indexes.getCapabilities().length];
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
        for (SPIRVCapability capability : _composite.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _indexes.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }

        return allCapabilities;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SPIRVOpCompositeExtract) {
            SPIRVOpCompositeExtract otherInst = (SPIRVOpCompositeExtract) other;
            if (!this._idResultType.equals(otherInst._idResultType)) return false;
            if (!this._composite.equals(otherInst._composite)) return false;
            if (!this._indexes.equals(otherInst._indexes)) return false;
            return true;
        }
        else return super.equals(other);
    }
}
