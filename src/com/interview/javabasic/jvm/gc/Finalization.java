package com.interview.javabasic.jvm.gc;

/**
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class Finalization {
    public static Finalization finalization;

    @Override
    protected void finalize() {
        System.out.println("Finalized");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("First print: " + f);
        f = null;
        System.gc();
        // 休息一段时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Second print: " + f);
        System.out.println(finalization);

    }
}
