package com.redsxi;

import java.nio.ByteBuffer;

public class CbaaChar extends VariableCbaaObjBase<Character> {
    @Override
    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(Character.BYTES);
        buffer.putChar(obj);
        buffer.flip();
        return buffer.array();
    }

    public CbaaChar(byte[] src) {
        ByteBuffer buffer = ByteBuffer.allocate(Character.BYTES);
        buffer.put(src);
        buffer.flip();
        obj = buffer.getChar();
    }
}
