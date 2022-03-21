package com.leetcode.offer.q59;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-21
 */
public class MaxQueue {
    private final Queue<Integer> queue;
    private final PriorityQueue<Integer> maxQueue;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.maxQueue = new PriorityQueue<>((x, y) -> y - x);
    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peek();
    }

    public void push_back(int value) {
        maxQueue.offer(value);
        queue.add(value);
    }

    public int pop_front() {
        if (!maxQueue.isEmpty()) maxQueue.remove(queue.peek());
        return queue.isEmpty() ? -1 : queue.remove();
    }
}
