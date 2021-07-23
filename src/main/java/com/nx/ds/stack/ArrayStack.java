package com.nx.ds.stack;

import com.nx.ds.array.Array;
import lombok.ToString;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-22
 */
@ToString
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peak() {
        return array.getLast();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
