package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread start : " + name + ",i=" + i);
        }
    }
}
