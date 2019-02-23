package com.interview.javabasic.thread;

/**
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    try {

                        System.out.println("thread A get lock");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
//                        Thread.sleep(1000);
//                        lock.wait(1000);
                        lock.wait();
                        System.out.println("thread A is done");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    try {

                        System.out.println("thread B get lock");
//                        lock.wait(10);
                        Thread.sleep(10);
                        lock.notifyAll();
                        Thread.yield();
                        Thread.sleep(2000);
                        System.out.println("thread B is sleeping 10 ms");
                        System.out.println("thread B is done");
                        lock.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
