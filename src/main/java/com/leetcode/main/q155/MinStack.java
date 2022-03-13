package com.leetcode.main.q155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-12
 * @see com.leetcode.offer.q30.MinStack
 */
public class MinStack {
    private final Deque<Integer> stack, minStack;

    public MinStack() {
        this.stack = new LinkedList<>();
        // 通过一个额外的栈, 每次发现有最小值就压入, 每次弹出就查看是否与栈顶一致
        this.minStack = new LinkedList<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
