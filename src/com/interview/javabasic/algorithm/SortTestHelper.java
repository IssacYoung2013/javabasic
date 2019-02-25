package com.interview.javabasic.algorithm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class SortTestHelper {

    private SortTestHelper() {

    }

    /**
     * 生成n个元素的随机数组，每个元素的随机范围为[rangeL,rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1)));
        }
        return arr;
    }

    /**
     * 生成一个近乎有序的数组
     * @param n
     * @param swapTimes 交换次数为0 完全有序 次数越多顺序越乱序
     * @return
     */
    public static Integer[] generateNearlyOrderArray(int n,int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }

        for (int i = 0; i < swapTimes; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();

        return;
    }

    /**
     * 判断数组是否有序
     *
     * @param arr
     * @return
     */
    private static boolean isSorted(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1].compareTo(arr[i]) < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 测试排序算法的性能
     *
     * @param className
     * @param arr
     */
    public static void testSort(String className, Comparable[] arr) {

        try {
            Class sortClass = Class.forName(className);
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            Object[] params = new Object[]{arr};

            long beginTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + ":" + (endTime - beginTime) + "ms");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
