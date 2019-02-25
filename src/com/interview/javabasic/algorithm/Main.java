package com.interview.javabasic.algorithm;

import java.util.Arrays;

/**
 *
 * author:  ywy
 * date:    2019-02-24
 * desc:
 */
public class Main {
    public static void main(String[] args) {
        int N = 50000;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
//        Integer[] arr1 = SortTestHelper.generateNearlyOrderArray(N, 0);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr41 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr42 = Arrays.copyOf(arr1,arr1.length);

        System.out.println("Test for random Array");
        SortTestHelper.testSort(packageName + "SelectionSort", arr1);

        SortTestHelper.testSort(packageName + "InsertionSort", arr2);
        SortTestHelper.testSort(packageName + "MergeSort", arr3);
        SortTestHelper.testSort(packageName + "QuickSort", arr4);
        SortTestHelper.testSort(packageName + "QuickSort2", arr41);
        SortTestHelper.testSort(packageName + "QuickSort3", arr42);

        System.out.println("Test for nearlyOrder Array");

        Integer[] arr5 = SortTestHelper.generateNearlyOrderArray(N, 0);
        Integer[] arr6 = Arrays.copyOf(arr5,arr5.length);
        Integer[] arr7 = Arrays.copyOf(arr5,arr5.length);
        Integer[] arr8 = Arrays.copyOf(arr5,arr5.length);

        SortTestHelper.testSort(packageName + "SelectionSort", arr5);
        SortTestHelper.testSort(packageName + "InsertionSort", arr6);
        SortTestHelper.testSort(packageName + "MergeSort", arr7);
        SortTestHelper.testSort(packageName + "QuickSort", arr8);



        return;
    }
}
