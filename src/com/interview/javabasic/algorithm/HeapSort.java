package com.interview.javabasic.algorithm;

import com.interview.javabasic.algo.SortTestHelper;

/**
 * author:  ywy
 * date:    2019-02-25
 * desc:
 */
public class HeapSort {

    private HeapSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // heapify
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown2(arr, i, 0);
        }
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j+=1;
            }
            if (arr[k].compareTo(arr[j]) > 0) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    private static void shiftDown2(Comparable[] arr, int n, int k) {

        Comparable v = arr[k];

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j+=1;
            }
            if (arr[k].compareTo(arr[j]) > 0) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }

        arr[k] = v;
    }

    private static void swap(Comparable[] arr, int a, int b) {
        try {
            Comparable t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) {

        int N = 50000;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort(packageName + "HeapSort", arr1);
        return;
    }
}
