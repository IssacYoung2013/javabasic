package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-18
 * desc:
 */
public class SyncDemo {
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread A_thread1 = new Thread(syncThread,"A_thread1");
        Thread A_thread2 = new Thread(syncThread,"A_thread2");
        Thread B_thread1 = new Thread(syncThread,"B_thread1");
        Thread B_thread2 = new Thread(syncThread,"B_thread2");
        Thread C_thread1 = new Thread(syncThread,"C_thread1");
        Thread C_thread2 = new Thread(syncThread,"C_thread2");

//        Thread A_thread1 = new Thread(new SyncThread(),"A_thread1");
//        Thread A_thread2 = new Thread(new SyncThread(),"A_thread2");
//        Thread B_thread1 = new Thread(new SyncThread(),"B_thread1");
//        Thread B_thread2 = new Thread(new SyncThread(),"B_thread2");
//        Thread C_thread1 = new Thread(new SyncThread(),"C_thread1");
//        Thread C_thread2 = new Thread(new SyncThread(),"C_thread2");

        A_thread1.start();
        A_thread2.start();
        B_thread1.start();
        B_thread2.start();
        C_thread1.start();
        C_thread2.start();

    }
}
