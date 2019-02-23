package com.interview.javabasic.thread;

/**
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class IntrruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable interrupTask = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {

                    while (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(100);
                        i++;
                        System.out.println(Thread.currentThread().getName() + "(" +
                                Thread.currentThread().getState() + ")" + " loop" + i);
                    }
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + "(" +
                            Thread.currentThread().getState()+") catched " + e.getMessage());
                }
            }
        };

        Thread t1 = new Thread(interrupTask,"t1");
        System.out.println(t1.getName() + "(" + t1.getState()+") is new");

        t1.start();
        System.out.println(t1.getName() + "(" + t1.getState()+") is started");

        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName() + "(" + t1.getState()+") is interrupted");

    }
}
