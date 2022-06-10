package com.leetcode.main.interval201.q225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-10
 */
public class MyStack {
    private Queue<Integer> queue1, queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    /**
     * 每次新元素放入空的queue1中, 然后将queue2依次放入queue1
     * 交换两个队列指针, 保证queue2始终按照栈排出顺序排序
     */
    public void push(int x) {
        queue1.add(x);
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public int pop() {
        return queue2.remove();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
}
