package uk.ac.manchester.spirvproto.lib.instructions;

import uk.ac.manchester.spirvproto.lib.disassembler.SPIRVPrintingOptions;
import uk.ac.manchester.spirvproto.lib.instructions.operands.*;

import javax.annotation.Generated;
import java.io.PrintStream;
import java.nio.ByteBuffer;

@Generated("beehive-lab.spirv-proto.generator")
public class SPIRVOpSwitch extends SPIRVTerminationInst {
    public final SPIRVId _selector;
    public final SPIRVId _default;
    public final SPIRVMultipleOperands<SPIRVPairLiteralIntegerIdRef> _target;

    public SPIRVOpSwitch(SPIRVId _selector, SPIRVId _default, SPIRVMultipleOperands<SPIRVPairLiteralIntegerIdRef> _target) {
        super(251, _selector.getWordCount() + _default.getWordCount() + _target.getWordCount() + 1, "OpSwitch");
        this._selector = _selector;
        this._default = _default;
        this._target = _target;
    }

    @Override
    protected void writeOperands(ByteBuffer output) {
        _selector.write(output);
        _default.write(output);
        _target.write(output);
    }

    @Override
    protected void printOperands(PrintStream output, SPIRVPrintingOptions options) {
         
        _selector.print(output, options);
        output.print(" ");
 
        _default.print(output, options);
        output.print(" ");
 
        _target.print(output, options);
    }

    @Override
    public SPIRVId getResultId() {
        return null;
    }

    @Override
    public SPIRVCapability[] getAllCapabilities() {
        SPIRVCapability[] allCapabilities = new SPIRVCapability[this.capabilities.length + _selector.getCapabilities().length + _default.getCapabilities().length + _target.getCapabilities().length];
        int capPos = 0;
        for (SPIRVCapability capability : this.capabilities) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _selector.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _default.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }
        for (SPIRVCapability capability : _target.getCapabilities()) {
            allCapabilities[capPos++] = capability;
        }

        return allCapabilities;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SPIRVOpSwitch) {
            SPIRVOpSwitch otherInst = (SPIRVOpSwitch) other;
            if (!this._selector.equals(otherInst._selector)) return false;
            if (!this._default.equals(otherInst._default)) return false;
            if (!this._target.equals(otherInst._target)) return false;
            return true;
        }
        else return super.equals(other);
    }
}
