package com.interview.javabasic.algo;

/**
 * author:  ywy
 * date:    2019-02-25
 * desc:
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }

            swap(arr,i,minIndex);
        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) {
        int N = 10000;
        String packageName = "com.interview.javabasic.algo.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort(packageName + "SelectionSort",arr1);
        return;
    }
}
