package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-18
 * desc:
 */
public class StringBufferWithoutSync {
    public void add(String str1,String str2) {
        // StringBuffer是线程安全
        // sb 不属于共享资源，JVM会自动消除内部锁
        StringBuffer sb = new StringBuffer();
        sb.append(str1).append(str2);
    }

    public static void main(String[] args) {
        StringBufferWithoutSync withoutSync = new StringBufferWithoutSync();
        for (int i = 0; i < 1000; i++) {
            withoutSync.add("aaa","bbb");
        }
    }
}
