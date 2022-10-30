package com.redsxi;

public class CbaaBoolean extends VariableCbaaObjBase<Boolean> {
    private static final byte TRUE = 1;
    private static final byte FALSE = 0;

    private byte boolToByte(boolean bool) {
        if(bool) return TRUE; else return FALSE;
    }

    private boolean byteToBool(byte b) {
        if(b == FALSE) return false;
        if(b == TRUE) return true;
        throw new IllegalArgumentException("Not a legal boolean value");
    }

    @Override
    public byte[] toByteArray() {
        return new byte[]{boolToByte(obj)};
    }

    public CbaaBoolean(byte[] src) {
        obj = byteToBool(new CbaaByte(src).get());
    }
}
