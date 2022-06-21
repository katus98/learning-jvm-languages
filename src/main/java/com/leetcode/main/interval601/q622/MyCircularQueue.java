package com.leetcode.main.interval601.q622;

/**
 * 设计循环队列
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-21
 */
public class MyCircularQueue {
    private final int[] array;
    /**
     * 队列头部
     */
    private int front;
    /**
     * 队列尾部的下一个
     */
    private int rear;

    public MyCircularQueue(int k) {
        this.array = new int[k + 1];
        this.front = 0;
        this.rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[rear % array.length] = value;
        rear = (rear + 1) % array.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % array.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[front % array.length];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(rear + array.length - 1) % array.length];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % array.length == front;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(2));
        System.out.println(queue.Rear());
        System.out.println(queue.Front());
        System.out.println(queue.deQueue());
    }
}
