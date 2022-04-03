package com.leetcode.base;

import java.util.Comparator;

/**
 * 通用堆
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class Heap<T> {
    private final int capacity;
    private final Comparator<T> comparator;
    private final Object[] array;
    private int size;

    public Heap(int capacity, Comparator<T> comparator) {
        this.capacity = capacity;
        this.comparator = comparator;
        this.array = new Object[capacity + 1];
        this.size = 0;
    }

    public void offer(T x) {
        array[++size] = x;
        updateLast();
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        Object res = array[1];
        swap(1, size--);
        updateFirst();
        return (T) res;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) array[1];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    @SuppressWarnings("unchecked")
    private void updateLast() {
        int i = size;
        while (i / 2 > 0) {
            if (comparator.compare((T) array[i / 2], (T) array[i]) > 0) {
                swap(i / 2, i);
            }
            i /= 2;
        }
    }

    @SuppressWarnings("unchecked")
    private void updateFirst() {
        int i = 1, sp;
        while ((i << 1) <= size) {
            int son1 = (i << 1), son2 = (i << 1) + 1;
            if (comparator.compare((T) array[son1], (T) array[i]) < 0) {
                sp = son1;
            } else {
                sp = i;
            }
            if (son2 <= size && comparator.compare((T) array[son2], (T) array[sp]) < 0) {
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
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
