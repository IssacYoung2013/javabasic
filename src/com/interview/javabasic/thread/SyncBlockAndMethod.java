package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-18
 * desc:
 */
public class SyncBlockAndMethod {
    public void syncsTask() {
        // 同步代码块
        synchronized (this) {
            System.out.println("Hello");
            synchronized (this) {
                System.out.println("World");
            }
        }
    }
    
    public  synchronized void syncTask() {
        System.out.println("Hello Again");
    }
}
