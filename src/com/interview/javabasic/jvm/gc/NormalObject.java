package com.interview.javabasic.jvm.gc;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class NormalObject {
    public String name;

    public NormalObject(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing obj " + name);
    }
}
