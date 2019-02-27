package com.interview.javabasic.algo;

/**
 *
 * author:  ywy
 * date:    2019-02-25
 * desc:
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {

            Comparable v = arr[i];
            int j;
            for (j = i ; j > 0 && arr[j-1].compareTo(v) >0 ; j--) {
               arr[j] = arr[j-1];
            }

            arr[j] = v;
        }
    }

    public static void main(String[] args) {
        int N = 10000;
        String packageName = "com.interview.javabasic.algo.";
//        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr1 = SortTestHelper.generateNealyOrderArray(N,5);

        SortTestHelper.testSort(packageName + "InsertionSort",arr1);
        return;
    }
}
