package com.interview.javabasic.reflect;

/**
 *
 * author:  ywy
 * date:    2019-02-16
 * desc:
 */
public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader cl = Robot.class.getClassLoader();
//        Class r = Class.forName("com.interview.javabasic.reflect.Robot");
        Class.forName("com.mysql.jdbc.Driver");
        // Spring IOC lazy loader
    }
}
