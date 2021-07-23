package com.nx.ds.array;

import lombok.ToString;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-21
 */
@ToString
public class Array<E> {
    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        this.size = 0;
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (size == capacity()) {
            resize(2 * capacity());
        }
        checkIndex(index);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        return find(e) != -1;
    }

    public E remove(int index) {
        checkIndex(index);
        E ele = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        // lazy 处理
        if (size == capacity() / 4 && capacity() / 2 != 0) {
            resize(capacity() / 2);
        }
        return ele;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Index is illegal");
        }
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
