package com.interview.javabasic.thread;

/**
 *
 * author:  ywy
 * date:    2019-02-19
 * desc:
 */
public class CASCase {
    public volatile  int value;

    public void add() {
        value++;
    }
}
