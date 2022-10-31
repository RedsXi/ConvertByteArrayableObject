package com.redsxi;

import java.nio.ByteBuffer;

public class CbaaDouble extends VariableCbaaObjBase<Double> {
    @Override
    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(Double.BYTES);
        buffer.putDouble(obj);
        buffer.flip();
        return buffer.array();
    }

    public CbaaDouble(byte[] src) {
        ByteBuffer buffer = ByteBuffer.allocate(Double.BYTES);
        buffer.put(src);
        buffer.flip();
        obj = buffer.getDouble();
    }

    public CbaaDouble(double v) {
        obj = v;
    }
}
