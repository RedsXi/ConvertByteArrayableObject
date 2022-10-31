package com.redsxi;

import com.redsxi.annotations.StaticByteArrayLength;

import java.nio.ByteBuffer;

@StaticByteArrayLength(8)
public class CbaaLong extends VariableCbaaObjBase<Long> {
    @Override
    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(obj);
        buffer.flip();
        return buffer.array();
    }

    public CbaaLong(byte[] src) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(src);
        buffer.flip();
        obj = buffer.getLong();
    }

    public CbaaLong(long v) {
        obj = v;
    }
}
