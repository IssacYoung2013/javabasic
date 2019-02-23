package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread start : " + name + ",i=" + i);
        }
    }
}
