package uk.ac.manchester.spirvproto.lib.instructions;

import uk.ac.manchester.spirvproto.lib.disassembler.SPIRVPrintingOptions;
import uk.ac.manchester.spirvproto.lib.instructions.operands.*;

import javax.annotation.Generated;
import java.io.PrintStream;
import java.nio.ByteBuffer;

@Generated("beehive-lab.spirv-proto.generator")
public class SPIRVOpSubgroupShuffleINTEL extends SPIRVInstruction {
    public final SPIRVId _idResultType;
    public final SPIRVId _idResult;
    public final SPIRVId _data;
    public final SPIRVId _invocationId;

    public SPIRVOpSubgroupShuffleINTEL(SPIRVId _idResultType, SPIRVId _idResult, SPIRVId _data, SPIRVId _invocationId) {
        super(5571, _idResultType.getWordCount() + _idResult.getWordCount() + _data.getWordCount() + _invocationId.getWordCount() + 1, "OpSubgroupShuffleINTEL", SPIRVCapability.SubgroupShuffleINTEL());
        this._idResultType = _idResultType;
        this._idResult = _idResult;
        this._data = _data;
        this._invocationId = _invocationId;
    }

    @Override
    protected void writeOperands(ByteBuffer output) {
        _idResultType.write(output);
        _idResult.write(output);
        _data.write(output);
        _invocationId.write(output);
    }

    @Override
    protected void printOperands(PrintStream output, SPIRVPrintingOptions options) {
         
        _idResultType.print(output, options);
        output.print(" ");
  
        _data.print(output, options);
        output.print(" ");
 
        _invocationId.print(output, options);
    }

    @Override
    public SPIRVId getResultId() {
        return _idResult;
    }

    @Override
    public SPIRVCapability[] getAllCapabilities() {
        SPIRVCapability[] allCapabilities = new SPIRVCapability[this.capabilities.length + _idResultType.getCapabilities().length + _idResult.getCapabilities().length + _data.getCapabilities().length + _invocationId.getCapabilities().length];
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
        for (SPIRVCapability capability : _data.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _invocationId.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }

        return allCapabilities;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SPIRVOpSubgroupShuffleINTEL) {
            SPIRVOpSubgroupShuffleINTEL otherInst = (SPIRVOpSubgroupShuffleINTEL) other;
            if (!this._idResultType.equals(otherInst._idResultType)) return false;
            if (!this._data.equals(otherInst._data)) return false;
            if (!this._invocationId.equals(otherInst._invocationId)) return false;
            return true;
        }
        else return super.equals(other);
    }
}
