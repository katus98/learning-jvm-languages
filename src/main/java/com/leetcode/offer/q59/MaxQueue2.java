package com.leetcode.offer.q59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-21
 */
public class MaxQueue2 {
    private final Queue<Integer> queue;
    private final Deque<Integer> maxQueue;

    public MaxQueue2() {
        this.queue = new LinkedList<>();
        this.maxQueue = new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    /**
     * 当一个元素入队, 前面相对较小的元素就不会对max有影响了, 所以删除所有小的数值后入队
     */
    public void push_back(int value) {
        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
        queue.add(value);
    }

    /**
     * 队首是最大值, 当移除的元素是最大值时移除最大值
     */
    public int pop_front() {
        if (queue.isEmpty()) return -1;
        Integer item = queue.remove();
        if (!maxQueue.isEmpty() && item.equals(maxQueue.peekFirst())) maxQueue.removeFirst();
        return item;
    }
}
