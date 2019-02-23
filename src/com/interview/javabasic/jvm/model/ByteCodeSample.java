package com.interview.javabasic.jvm.model;

/**
 * author:  ywy
 * date:    2019-02-16
 * desc:
 */
public class ByteCodeSample {
    public static int add(int a, int b) {
        int c = 0;
        c = a + b;
        String s = new String("a");
        s.intern();
        return c;
    }
}
