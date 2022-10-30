package com.redsxi;


import com.redsxi.annotations.StaticByteArrayLength;

/**
 * An object that can convert to byte array.
 * @param <CbaaObject>
 */
public abstract class ConvertByteArrayAbleObject<CbaaObject extends ConvertByteArrayAbleObject<CbaaObject>> {
    public abstract byte[] toByteArray();

    public byte[] initialByteArrayIfStaticLength() {
        StaticByteArrayLength annotation = this.getClass().getAnnotation(StaticByteArrayLength.class);
        if(annotation != null) {
            return new byte[annotation.value()];
        }
        return null;
    }

    public ConvertByteArrayAbleObject() {

    }

    public ConvertByteArrayAbleObject(byte[] src) {
        StaticByteArrayLength annotation = this.getClass().getAnnotation(StaticByteArrayLength.class);
        if(annotation != null) {
            if(annotation.value() != src.length) throw new IllegalArgumentException("Invalid byte array size");
        }
    }

    public abstract int length();
}
