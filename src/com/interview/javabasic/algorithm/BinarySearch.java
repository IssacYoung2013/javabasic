package com.interview.javabasic.algorithm;

/**
 * author:  ywy
 * date:    2019-02-26
 * desc:
 */
public class BinarySearch {

    private BinarySearch() {
    }

    /**
     * @param arr    有序数组
     * @param target
     * @return
     */
    public static int find(Comparable[] arr, Comparable target) {
        int n = arr.length;

        // 在 arr[l..r]之中查找target
        int l = 0, r = n - 1;
        while (l <= r) {

//            int mid = (l+r) /2;
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }

            if (target.compareTo(arr[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 10000;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort(packageName + "BubbleSort", arr1);

        System.out.println(find(arr1, 4123));

        return;
    }

}
