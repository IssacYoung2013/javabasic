package com.interview.javabasic.thread;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws Exception{
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        if(!task.isDone()) {
            System.out.println("task has not finished,please wait!");
        }
        System.out.println("task finish " + task.get());
    }
}
