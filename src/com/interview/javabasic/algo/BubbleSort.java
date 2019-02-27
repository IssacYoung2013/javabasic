package com.interview.javabasic.algo;

/**
 * author:  ywy
 * date:    2019-02-25
 * desc:
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        boolean isSwapped = true;

        do {
            isSwapped = false;

            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                    isSwapped = true;
                }
            }

            n--;

        } while (isSwapped);
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) {
        int N = 10000;
        String packageName = "com.interview.javabasic.algo.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
//        Integer[] arr1 = SortTestHelper.generateNealyOrderArray(N,5);

        SortTestHelper.testSort(packageName + "BubbleSort", arr1);
        return;
    }
}
