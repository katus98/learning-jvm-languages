package com.leetcode.offer.q9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-06
 */
public class CQueue {
    /**
     * LIFO Stack 务必认准Deque接口, Vector接口已过时, 往往无法通过
     */
    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;

    public CQueue() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
