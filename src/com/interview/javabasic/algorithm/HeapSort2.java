package com.interview.javabasic.algorithm;

import com.interview.javabasic.algo.SortTestHelper;

/**
 *
 * author:  ywy
 * date:    2019-02-25
 * desc:
 */
public class HeapSort2 {

    private HeapSort2() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr,n);

        for (int i = n- 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {

        int N = 10000;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort(packageName + "HeapSort2",arr1);
        return;
    }

}
