package com.interview.javabasic.algorithm;

/**
 * author:  ywy
 * date:    2019-02-25
 * desc:
 */
public class IndexMaxHeap<Item extends Comparable> {

    protected Item[] data;

    protected int[] indexs;

    protected int[] reverse;

    protected int count;
    private int capacity;

    public IndexMaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        indexs = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i < capacity; i++) {
            reverse[i] = 0;
        }
        count = 0;
        capacity = capacity;
    }

    public IndexMaxHeap(Item[] arr, int n) {

        data = (Item[]) new Comparable[n + 1];

        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }

        count = n;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // i于用户 是从0开始的索引
    public void insert(int i, Item item) {

        assert count + 1 <= capacity;

        assert (i + 1 >= 1 && i + 1 <= capacity);

        i += 1;

        data[i] = item;
        indexs[count + 1] = i;
        reverse[i] = count + 1;
        count++;

        shiftUp(count);
    }

    public Item extractMax() {
        assert count > 0;

        Item ret = data[indexs[1]];

        swap(1, count);
        reverse[indexs[1]] = 1;
        reverse[indexs[count]] = 0;
        count--;

        shiftDown(1);

        return ret;
    }

    public boolean contain(int i) {

        assert i + 1 >= 1 && i+ 1 <= capacity;

        return reverse[i + 1] != 0;
    }

    public Item getItem(int i) {

        assert contain(i);

        return data[i + 1];
    }

    void change(int i, Item newItem) {

        assert contain(i);

        i += 1;
        data[i] = newItem;

        // 找到indexs[j] = i j 表示data[i]堆中的位置
        // 之后ShiftUp(j) ShiftDown(j)

//        for (int j = 0; j <= count; j++) {
//            if (indexs[j] == i) {
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }
//        }

        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    public int extractMaxIndex() {
        assert count > 0;

        int ret = indexs[1] - 1;

        swap(1, count);
        reverse[indexs[count]] = 0;
        count--;

        shiftDown(1);

        return ret;
    }

    private void shiftDown(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexs[j + 1]].compareTo(data[indexs[j]]) > 0) {
                j++;
            }
            if (data[indexs[k]].compareTo(data[indexs[j]]) > 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }


    private void shiftUp(int k) {
        while (k > 1 && data[indexs[k / 2]].compareTo(data[indexs[k]]) < 0) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    private void swap(int a, int b) {
        int t = indexs[a];
        indexs[a] = indexs[b];
        indexs[b] = t;

        reverse[indexs[a]] = a;
        reverse[indexs[b]] = b;
    }

    public static void main(String[] args) {
        IndexMaxHeap<Integer> maxHeap = new IndexMaxHeap<>(100);
        int N = 50, M = 100;


        System.out.println(maxHeap.size());
    }

}
