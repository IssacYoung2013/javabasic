package com.interview.javabasic.algorithm;

/**
 *
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class SortTestHelper {

    private SortTestHelper() {

    }

    /**
     * 生成n个元素的随机数组，每个元素的随机范围为[rangeL,rangeR]
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n,int rangeL,int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1)));
        }
        return arr;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();

        return;
    }
}
