package com.leetcode.base;

/**
 * 整型堆
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class IntHeap {
    private final int capacity;
    private final HeapComparator comparator;
    private final int[] array;
    private int size;

    public IntHeap(int capacity, HeapComparator comparator) {
        this.capacity = capacity;
        this.comparator = comparator;
        this.array = new int[capacity + 1];
        this.size = 0;
    }

    public IntHeap(int capacity) {
        this(capacity, (a, b) -> a - b);
    }

    public void offer(int x) {
        array[++size] = x;
        updateLast();
    }

    public int pop() {
        int res = array[1];
        swap(1, size--);
        updateFirst();
        return res;
    }

    public int peek() {
        return array[1];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    private void updateLast() {
        int i = size;
        while (i / 2 > 0) {
            if (comparator.compare(array[i / 2], array[i]) > 0) {
                swap(i / 2, i);
            }
            i /= 2;
        }
    }

    private void updateFirst() {
        int i = 1, sp;
        while ((i << 1) <= size) {
            int son1 = (i << 1), son2 = (i << 1) + 1;
            if (comparator.compare(array[son1], array[i]) < 0) {
                sp = son1;
            } else {
                sp = i;
            }
            if (son2 <= size && comparator.compare(array[son2], array[sp]) < 0) {
                sp = son2;
            }
            if (sp != i) {
                swap(sp, i);
                i = sp;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @FunctionalInterface
    public interface HeapComparator {
        int compare(int a, int b);
    }
}
