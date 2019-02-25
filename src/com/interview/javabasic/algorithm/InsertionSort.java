package com.interview.javabasic.algorithm;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            Comparable temp = arr[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 10000;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort(packageName + "InsertionSort", arr1);
        return;
    }
}
