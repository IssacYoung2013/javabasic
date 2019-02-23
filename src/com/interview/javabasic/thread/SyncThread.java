package com.interview.javabasic.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:  ywy
 * date:    2019-02-18
 * desc:
 */
public class SyncThread implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.startsWith("A")) {
            async();
        } else if (threadName.startsWith("B")) {
            syncObjectBlock1();
        } else if (threadName.startsWith("C")) {
            syncObjectMethod1();
        } else if (threadName.startsWith("D")) {
            syncObjectClass1();
        } else if (threadName.startsWith("E")) {
            syncObjectClass1();
        }
    }

    private synchronized void syncObjectMethod1() {
        System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        try {
            System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod_Start:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod_End:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized static void syncObjectClass1() {
        System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        try {
            System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod_Start:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod_End:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void syncObjectBlock1() {
        System.out.println(Thread.currentThread().getName() + "_SyncObject:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + "_SyncObject_Start:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "_SyncObjectBlock_End:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void syncClassBlock1() {
        System.out.println(Thread.currentThread().getName() + "_SyncObject:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        synchronized (SyncThread.class) {
            try {
                System.out.println(Thread.currentThread().getName() + "_SyncObject_Start:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "_SyncObjectBlock_End:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void async() {
        try {
            System.out.println(Thread.currentThread().getName() + "_Async_Start:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "_Async_End:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
