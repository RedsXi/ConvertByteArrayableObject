package com.redsxi;

import java.nio.ByteBuffer;

public class CbaaShort extends VariableCbaaObjBase<Short> {
    @Override
    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
        buffer.putShort(obj);
        buffer.flip();
        return buffer.array();
    }

    public CbaaShort(byte[] src) {
        ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
        buffer.put(src);
        buffer.flip();
        obj = buffer.getShort();
    }

    public CbaaShort(short v) {
        obj = v;
    }
}
