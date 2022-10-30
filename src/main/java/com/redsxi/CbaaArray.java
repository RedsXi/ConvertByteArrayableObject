package com.redsxi;

import com.redsxi.annotations.StaticByteArrayLength;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.List;

public class CbaaArray extends VariableCbaaObjBase<List<? extends VariableCbaaObjBase<?>>> {

    private static long LIMIT_LENGTH = Integer.MAX_VALUE;
    @Override
    public byte[] toByteArray() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(obj.getClass().getTypeParameters()[0].getAnnotation(StaticByteArrayLength.class).value());
            buffer.putInt(obj.size());
            for(VariableCbaaObjBase<?> single : obj) {
                buffer.put(single.toByteArray());
            }
            return buffer.array();
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | BufferOverflowException e)
        {
            throw new RuntimeException(e);
        }
    }
}
