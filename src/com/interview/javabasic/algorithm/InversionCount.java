package com.interview.javabasic.algorithm;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class InversionCount {
    private InversionCount() {
    }

    public static long count(Comparable[] arr) {

        int n = arr.length;

        return countInversion(arr, 0, n - 1);

    }

    private static long countInversion(Comparable[] arr, int l, int r) {
        if (r <= l) {
            return 0L;
        }

        int mid = l + (r-l) / 2;

        long res1 = countInversion(arr, l, mid);
        long res2 = countInversion(arr, mid + 1, r);

        return res1 + res2 + count(arr, l, mid, r);
    }

    private static long count(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        long inversionCount = 0L;

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(arr[j - l]) <= 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                inversionCount += (long) (mid - i + 1);
                arr[k] = aux[j - l];
                j++;

            }
        }
        return inversionCount;
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
        int N = 5;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
//        Integer[] arr1 = SortTestHelper.generateNearlyOrderArray(N, 0);
        SortTestHelper.printArray(arr1);

        System.out.println("Inversion Count : " + count(arr1));

        SortTestHelper.printArray(arr1);
        return;
    }
}
