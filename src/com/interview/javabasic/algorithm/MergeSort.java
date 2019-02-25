package com.interview.javabasic.algorithm;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class MergeSort {
    private MergeSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        mergeSort(arr, 0, n - 1);

    }

    private static void mergeSort(Comparable[] arr, int l, int r) {

//        if (l >= r) {
//            return;
//        }
        if(r -l <= 15) {
            InsertionSort.sort(arr);
            return;
        }

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(arr[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
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
        int N = 50000;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort(packageName + "MergeSort", arr1);
        return;
    }
}
