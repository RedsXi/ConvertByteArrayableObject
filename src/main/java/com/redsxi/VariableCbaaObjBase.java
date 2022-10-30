package com.redsxi;

import com.redsxi.annotations.StaticByteArrayLength;

public class VariableCbaaObjBase<V> extends ConvertByteArrayAbleObject<VariableCbaaObjBase<V>> {

    V obj;

    public VariableCbaaObjBase() {
    }

    public VariableCbaaObjBase(V o) {
        obj = o;
    }

    public VariableCbaaObjBase(byte[] src) {
        super(src);
    }

    @Override
    public byte[] toByteArray() {
        byte[] res = super.initialByteArrayIfStaticLength();

        if(res == null) throw new RuntimeException();

        return res;
    }

    public V get() {
        return obj;
    }

    public static <FV> VariableCbaaObjBase<FV> as(FV o) {
        return new VariableCbaaObjBase<>(o);
    }

    @Override
    public int length() {
        StaticByteArrayLength a = this.getClass().getAnnotation(StaticByteArrayLength.class);
        if(a == null) throw new RuntimeException();
        return a.value();
    }
}
