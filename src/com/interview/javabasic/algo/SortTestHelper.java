package com.interview.javabasic.algo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author:  ywy
 * date:    2019-02-25
 * desc:
 */
public class SortTestHelper {
    private SortTestHelper() {
    }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1)));
        }
        return arr;
    }

    public static Integer[] generateNealyOrderArray(int n, int swaptimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }

        for (int i = 0; i < swaptimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = arr[a];
            arr[b] = arr[a];
            arr[a] = t;
        }

        return arr;
    }

    private static boolean testIsSort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void testSort(String sortClassName, Comparable[] arr) {

        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort",new Class[] {Comparable[].class});

            Object[] params = new Object[] {arr};

            long beginTime = System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert testIsSort(arr);

            System.out.println(sortClass.getSimpleName() + " " + (endTime - beginTime) + "ms");

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

    public static void printArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
