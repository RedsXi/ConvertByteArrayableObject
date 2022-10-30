package com.redsxi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class CbaaStructure extends ConvertByteArrayAbleObject<CbaaStructure> {
    ConvertByteArrayAbleObject<?>[] obj_s;

    public abstract Class<? extends ConvertByteArrayAbleObject<?>>[] getStructureClasses();

    @Override
    public byte[] toByteArray() throws RuntimeException {
        byte[] result = new byte[length()];

        int offset = 0;

        for(ConvertByteArrayAbleObject<?> o : obj_s) {
            System.arraycopy(o.toByteArray(), 0, result, offset, o.length());
            offset += o.length();
        }

        return result;
    }

    public CbaaStructure(byte[] src) {
        int offset = 0;

        Class<? extends ConvertByteArrayAbleObject<?>>[] classes = getStructureClasses();

        int count = classes.length;

        obj_s = new ConvertByteArrayAbleObject<?>[count];

        try{
            for(int index = 0;index < count;index++) {
                byte[] p = new byte[src.length - offset];
                System.arraycopy(src, offset, p, 0, src.length - offset);
                Constructor<? extends ConvertByteArrayAbleObject<?>> constructor = classes[index].getConstructor(byte[].class);
                obj_s[index] = constructor.newInstance(p);
                offset += obj_s[index].length();
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public ConvertByteArrayAbleObject<?>[] getAll() {
        return obj_s;
    }

    @Override
    public int length() {
        int length = 0;

        for(ConvertByteArrayAbleObject<?> o : obj_s) {
            length += o.length();
        }

        return length;
    }
}