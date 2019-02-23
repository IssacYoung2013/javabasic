package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class NotificationDemo {

    private static volatile  boolean go = false;

    public static void main(String[] args) {
        final NotificationDemo test = new NotificationDemo();

        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                try {
                    test.shouldGo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished");
            }
        };

        Runnable notifyTask = new Runnable() {
            @Override
            public void run() {
                test.go();
                System.out.println(Thread.currentThread().getName() + " finished");

            }
        };

        Thread t1 = new Thread(waitTask,"WT1");
        Thread t2 = new Thread(waitTask,"WT2");
        Thread t3 = new Thread(waitTask,"WT3");
        Thread t4 = new Thread(notifyTask,"NT1");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t4.start();

    }

    private synchronized  void  shouldGo() throws InterruptedException {
        while (go != true) {
           wait();
           System.out.println(Thread.currentThread().getName() +  " thread woke up ");
        }
        go = false;
    }

    private synchronized void go() {

        while (go == false) {
            go = true;
            notifyAll();
        }
    }
}
