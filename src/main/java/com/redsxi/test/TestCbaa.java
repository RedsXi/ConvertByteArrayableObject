package com.redsxi.test;

import com.redsxi.CbaaInteger;
import com.redsxi.CbaaLong;
import com.redsxi.CbaaStructure;
import com.redsxi.ConvertByteArrayAbleObject;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class TestCbaa {
    public static void main(String[] args) {
        out.println("Test Cbaa: Struct(Int, Long)");
        Scanner sc = new Scanner(in);
        out.println("Enter a Integer:");
        TestStruct s = new TestStruct();
        s.obj_s[0] = new CbaaInteger(sc.nextInt());
        out.println("Enter a Long:");
        s.obj_s[1] = new CbaaLong(sc.nextLong());
        out.println("Result: " + Arrays.toString(s.toByteArray()));

    }

    private static class TestStruct extends CbaaStructure {

        public TestStruct(byte[] src) {
            super(src);
        }

        public TestStruct() {
            super();
        }

        @Override
        public Class<? extends ConvertByteArrayAbleObject<?>>[] getStructureClasses() {
            return new Class[]{CbaaInteger.class, CbaaLong.class};
        }
    }
}
