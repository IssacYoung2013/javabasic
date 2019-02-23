package com.interview.javabasic.thread;

import java.util.concurrent.Callable;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Read to work");
        Thread.sleep(5000);
        System.out.println("Task done.");
        return value;
    }
}
