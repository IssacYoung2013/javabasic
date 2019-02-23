package com.interview.javabasic.throwable;

/**
 *
 * author:  ywy
 * date:    2019-02-20
 * desc:
 */
public class ExceptionPerformance {
    public static void testException(String[] array) {
        try {
            System.out.println(array[0]);
        } catch (NullPointerException e) {
            System.out.println("array cannot be null");
        }
    }

    public static void testIf(String[] array) {
        if(array != null) {
            System.out.println(array[0]);
        } else {
            System.out.println("array can not be null");
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
//        testException(null); //cost 508765
        testIf(null); // cost 352548
        System.out.println("cost " + (System.nanoTime() - start));
    }
}
