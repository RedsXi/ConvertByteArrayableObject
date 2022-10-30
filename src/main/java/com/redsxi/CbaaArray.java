package com.redsxi;

import com.redsxi.annotations.StaticByteArrayLength;
import com.sun.tools.javac.util.Convert;

import java.lang.reflect.InvocationTargetException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class CbaaArray extends VariableCbaaObjBase<List<? super ConvertByteArrayAbleObject<?>>> {

    private static long LIMIT_LENGTH = Integer.MAX_VALUE;
    @Override
    public byte[] toByteArray() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(obj.getClass().getTypeParameters()[0].getAnnotation(StaticByteArrayLength.class).value());
            buffer.putInt(obj.size());
            for(Object single : obj) {
                buffer.put(((ConvertByteArrayAbleObject<?>)single).toByteArray());
            }
            return buffer.array();
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | BufferOverflowException e)
        {
            throw new RuntimeException(e);
        }
    }

    public CbaaArray(byte[] src) {
        obj = new ArrayList<>();
        ByteBuffer buf = ByteBuffer.allocate(src.length);
        buf.put(src);
        buf.flip();
        try {
            byte[] bufarr = buf.array();
            byte[] buf_without_length = new byte[bufarr.length - Integer.BYTES];
            byte[] single;
            int offset = 0;
            System.arraycopy(bufarr, Integer.BYTES, buf_without_length, 0, buf_without_length.length);
            int length = buf.getInt();
            for(int index = 0;index < length;index++) {
                single = new byte[buf_without_length.length - offset];
                System.arraycopy(buf_without_length,offset,single,0,single.length);
                ConvertByteArrayAbleObject<?> s = (
                        (Class<? extends ConvertByteArrayAbleObject<?>>)
                                obj
                                        .getClass()
                                        .getTypeParameters()[0]
                                        .getBounds()[
                                                obj
                                                        .getClass()
                                                        .getTypeParameters()[0]
                                                        .getBounds()
                                                        .length
                                                        ]
                )
                        .getConstructor(byte[].class)
                        .newInstance(single);
                offset += s.length();
                obj.add(s);

            }
        } catch (BufferOverflowException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
