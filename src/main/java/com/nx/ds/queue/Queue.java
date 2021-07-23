package com.nx.ds.queue;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-23
 */
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    int size();
    boolean isEmpty();
    E getFront();
}
