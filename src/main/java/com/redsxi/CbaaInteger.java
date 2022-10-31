package com.redsxi;

import com.redsxi.annotations.StaticByteArrayLength;

import java.nio.ByteBuffer;

@StaticByteArrayLength(4)
public class CbaaInteger extends VariableCbaaObjBase<Integer> {
    @Override
    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(obj);
        buffer.flip();
        return buffer.array();
    }

    public CbaaInteger(byte[] src) {
        super(src);
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.put(src);
        buffer.flip();
        obj = buffer.getInt();
    }

    public CbaaInteger(int v) {
        obj = v;
    }
}
