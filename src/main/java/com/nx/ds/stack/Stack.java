package com.nx.ds.stack;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-22
 */
public interface Stack<E> {
    void push(E e);
    E pop();
    E peak();
    int size();
    boolean isEmpty();
}
