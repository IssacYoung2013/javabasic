package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-18
 * desc:
 */
public class CoarseSync {
    public static String copyString100Times(String target) {
        int i =0;
        StringBuffer sb = new StringBuffer();
        // jvm检测到大量循环 加一次锁到循环外
        while (i<100) {
            sb.append(target);
        }
        return sb.toString();
    }
}
