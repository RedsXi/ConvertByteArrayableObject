package com.redsxi;

import java.nio.ByteBuffer;

public class CbaaByte extends VariableCbaaObjBase<Byte> {
    @Override
    public byte[] toByteArray() {
        return new byte[]{obj};
    }

    public CbaaByte(byte[] src) {
        if(src.length < 1) throw new RuntimeException("Array's length should be bigger than 0, but got 0");
        obj = src[0];
    }
}
