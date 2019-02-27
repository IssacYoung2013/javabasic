package com.interview.javabasic.algorithm;

/**
 * author:  ywy
 * date:    2019-02-25
 * desc:
 */
public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        capacity = capacity;
    }

    public MaxHeap(Item[] arr, int n) {

        data = (Item[]) new Comparable[n + 1];

        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i+1] = arr[i];
        }

        count = n;

        for (int i = count / 2 ; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Item item) {

        assert count + 1 <= capacity;

        data[count + 1] = item;
        count++;

        shiftUp(count);
    }

    public Item extractMax() {
        assert count > 0;

        Item ret = data[1];

        swap(1,count);
        count --;

        shiftDown(1);

        return ret;
    }

    private void shiftDown(int k) {

        while (2*k <= count) {
            int j = 2 * k;
            if(j + 1 <= count && data[j+1].compareTo(data[j]) > 0) {
                j++;
            }
            if(data[k].compareTo(data[j]) > 0) {
                break;
            }
            swap(k,j);
            k = j;
        }
    }


    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    private void swap(int a, int b) {
        Item t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int N = 50, M = 100;

        for (int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        }

        System.out.println(maxHeap.size());
    }

}
