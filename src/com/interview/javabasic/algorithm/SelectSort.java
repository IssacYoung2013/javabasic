package com.interview.javabasic.algorithm;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class SelectSort {
    private SelectSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // 查询最小数
                if(arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }

            swap(arr,i,minIndex);
        }
    }

    /**
     * 交换
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
        Integer[] arr = SortTestHelper.generateRandomArray(10,67,786);
        SortTestHelper.printArray(arr);
        sort(arr);
        SortTestHelper.printArray(arr);

        return;
    }

}
