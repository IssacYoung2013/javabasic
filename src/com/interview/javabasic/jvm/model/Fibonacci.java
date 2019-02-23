package com.interview.javabasic.jvm.model;

/**
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class Fibonacci {
    // f(0) = 0,f(1) = 1 当n>=2 f(n) = f(n-1) + f(n-2)

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(1000000));

    }
}
