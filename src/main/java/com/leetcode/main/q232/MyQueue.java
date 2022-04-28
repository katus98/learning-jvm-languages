package com.leetcode.main.q232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现队列
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-28
 */
public class MyQueue {
    private final Deque<Integer> stack1, stack2;

    public MyQueue() {
        // 用于入队
        this.stack1 = new LinkedList<>();
        // 用于出队
        this.stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.addFirst(x);
    }

    public int pop() {
        // 如果出队堆栈为空
        if (stack2.isEmpty()) {
            // 将入队堆栈全部压入出队堆栈
            while (!stack1.isEmpty()) {
                stack2.addFirst(stack1.removeFirst());
            }
        }
        return stack2.removeFirst();
    }

    public int peek() {
        // 如果出队堆栈为空
        if (stack2.isEmpty()) {
            // 将入队堆栈全部压入出队堆栈
            while (!stack1.isEmpty()) {
                stack2.addFirst(stack1.removeFirst());
            }
        }
        return stack2.peekFirst();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
