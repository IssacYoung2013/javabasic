package com.interview.javabasic.reflect;

/**
 *
 * author:  ywy
 * date:    2019-02-16
 * desc:
 */
public class Robot {
    private String name;
    public void sayHi(String helloSentence) {
        System.out.println(helloSentence+ " " + name);
    }
    private String throwHello(String tag) {
        return "Hello " + tag;
    }
    static {
        System.out.println("Hello Robot");
    }
}

