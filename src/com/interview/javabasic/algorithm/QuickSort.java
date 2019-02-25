package com.interview.javabasic.algorithm;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class QuickSort {

    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        quickSort(arr, 0, n - 1);

    }

    private static void quickSort(Comparable[] arr, int l, int r) {

        if(l > r) {
            return;
        }

//        if (r - l <= 15) {
//            InsertionSort.sort(arr);
//            return;
//        }
        int p = partition(arr, l, r);

        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1 , r);

    }

    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr,l,(int)(Math.random() * (r-l+1)));

        Comparable v = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i].compareTo(v) < 0) {
                swap(arr,++j,i);
            }
        }

        swap(arr,l,j);

        return j;
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
        int N = 50000;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        SortTestHelper.testSort(packageName + "QuickSort", arr1);
        return;
    }
}
