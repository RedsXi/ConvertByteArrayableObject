package com.redsxi;

import com.redsxi.annotations.StaticByteArrayLength;

import java.nio.ByteBuffer;

@StaticByteArrayLength(4)
public class CbaaFloat extends VariableCbaaObjBase<Float> {
    @Override
    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(Float.BYTES);
        buffer.putFloat(obj);
        buffer.flip();
        return buffer.array();
    }

    public CbaaFloat(byte[] src) {
        ByteBuffer buffer = ByteBuffer.allocate(Float.BYTES);
        buffer.put(src);
        buffer.flip();
        obj = buffer.getFloat();
    }
}
