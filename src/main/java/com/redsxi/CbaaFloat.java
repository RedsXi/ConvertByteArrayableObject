package com.redsxi;

import com.redsxi.annotations.StaticByteArrayLength;

@StaticByteArrayLength(4)
public class CbaaFloat extends VariableCbaaObjBase<Float> {
    @Override
    public byte[] toByteArray() throws RuntimeException {
        byte[] res = super.toByteArray();

        int obj = Float.floatToIntBits(this.obj);

        res[3] = (byte)((obj >> 24) & 0xFF);
        res[2] = (byte)((obj >> 16) & 0xFF);
        res[1] = (byte)((obj >> 8) & 0xFF);
        res[0] = (byte)(obj & 0xFF);

        return res;
    }

    public CbaaFloat(byte[] src) {
        super(src);
        obj = Float.intBitsToFloat(
                (src[0] & 0xFF) |
                        ((src[1] & 0xFF) << 8) |
                        ((src[2] & 0xFF) << 16) |
                        ((src[3] & 0xFF) << 24)
        );
    }
}
