package com.interview.javabasic.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * author:  ywy
 * date:    2019-02-18
 * desc:
 */
public class ReentrantLockDemo implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                System.out.println(Thread.currentThread().getName() + " get lock");

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        Thread thread1 = new Thread(reentrantLockDemo);
        Thread thread2 = new Thread(reentrantLockDemo);
        thread1.start();
        thread2.start();

    }
}
