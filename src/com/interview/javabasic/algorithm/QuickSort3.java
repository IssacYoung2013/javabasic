package com.interview.javabasic.algorithm;

/**
 * author:  ywy
 * date:    2019-02-23
 * desc:
 */
public class QuickSort3 {

    private QuickSort3() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        quickSort3(arr, 0, n - 1);

    }

    private static void quickSort3(Comparable[] arr, int l, int r) {

        if(l > r) {
            return;
        }

//        if (r - l <= 15) {
//            InsertionSort.sort(arr);
//            return;
//        }

        swap(arr,l,(int)(Math.random() * (r-l+1)));

        Comparable v = arr[l];

        int i = l + 1,lt = l,gt = r + 1;
        while (i < gt) {
            if(arr[i].compareTo(v) < 0) {
                swap(arr,i,lt + 1);
                lt++;
                i++;
            }
            else if(arr[i].compareTo(v) > 0) {
                swap(arr,i,gt -1);
                gt--;
            }else {
                i++;
            }
        }

        swap(arr,l,lt);


        quickSort3(arr, l, lt - 1);
        quickSort3(arr, gt , r);

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
        SortTestHelper.testSort(packageName + "QuickSort3", arr1);
        return;
    }
}
