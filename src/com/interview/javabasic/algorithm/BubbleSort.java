package com.interview.javabasic.algorithm;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        boolean swaped = true;

        do {
            swaped = false;
            for (int i = 1; i < n; i++) {
                if(arr[i].compareTo(arr[i-1]) < 0) {
                    swap(arr,i-1,i);
                    swaped = true;
                }
            }
            n--;
        } while (swaped);
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
        SortTestHelper.testSort(packageName + "BubbleSort", arr1);
        return;
    }
}
