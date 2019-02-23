package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("Thread1");
        MyThread myThread2 = new MyThread("Thread2");
        MyThread myThread3 = new MyThread("Thread3");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
