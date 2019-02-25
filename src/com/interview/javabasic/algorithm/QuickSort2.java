package com.interview.javabasic.algorithm;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class QuickSort2 {

    private QuickSort2() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        quickSort2(arr, 0, n - 1);

    }

    private static void quickSort2(Comparable[] arr, int l, int r) {

        if(l > r) {
            return;
        }

//        if (r - l <= 15) {
//            InsertionSort.sort(arr);
//            return;
//        }
        int p = partition2(arr, l, r);

        quickSort2(arr, l, p - 1);
        quickSort2(arr, p + 1 , r);

    }

    private static int partition2(Comparable[] arr, int l, int r) {

        swap(arr,l,(int)(Math.random() * (r-l+1)));

        Comparable v = arr[l];

        int i = l + 1,j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if(i > j) {
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }

        swap(arr,l,j);

        return j;
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
        int N = 50000;
        String packageName = "com.interview.javabasic.algorithm.";
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        SortTestHelper.testSort(packageName + "QuickSort2", arr1);
        return;
    }
}
