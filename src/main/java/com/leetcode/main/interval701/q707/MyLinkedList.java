package com.leetcode.main.interval701.q707;

/**
 * 设计链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-11
 */
public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
            Node node = head;
            while (index-- != 0) {
                node = node.next;
            }
            return node.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        this.head = new Node(val, head);
        this.size += 1;
    }

    public void addAtTail(int val) {
        Node before = new Node(-1, head);
        while (before.next != null) {
            before = before.next;
        }
        before.next = new Node(val);
        this.size += 1;
        if (size == 1) {
            this.head = before.next;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        }
        if (index > 0 && index <= size) {
            Node before = new Node(-1, head);
            while (index-- != 0) {
                before = before.next;
            }
            Node realNext = before.next;
            before.next = new Node(val, realNext);
            this.size += 1;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            this.head = head.next;
        }
        if (index > 0 && index < size) {
            Node before = new Node(-1, head);
            while (index-- != 0) {
                before = before.next;
            }
            before.next = before.next.next;
        }
    }

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0, 10);
        list.addAtIndex(0, 20);
        list.addAtIndex(1, 30);
        System.out.println(list.get(0));
    }
}
