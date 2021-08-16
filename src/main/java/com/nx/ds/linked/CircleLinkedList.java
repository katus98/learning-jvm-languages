package com.nx.ds.linked;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-13
 */
public class CircleLinkedList<E> {
    private Node head, tail;

    public CircleLinkedList(int num) {
        if (num < 1) {
            throw new RuntimeException("num < 1");
        }
        for (int i = 1; i <= num; i++) {
            Node node = new Node();
            if (i == 1) {
                head = node;
                head.next = head;
            } else {
                tail.next = node;
                node.next = head;
            }
            tail = node;
        }
    }

    public CircleLinkedList() {
        this(5);
    }

    public void exitCircle(int startNo, int countNum, int num) {
        if (head == null || startNo < 1 || startNo > num) {
            throw new RuntimeException("startNo!");
        }
        for (int i = 0; i < startNo - 1; i++) {
            head = head.next;
            tail = tail.next;
        }
        while (true) {
            if (tail == head) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                head = head.next;
                tail = tail.next;
            }
            System.out.println(head.e + " out");
            head = head.next;
            tail.next = head;
        }
        System.out.println(head.e + " last");
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private class Node {
        public E e;
        public Node next;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return "Node{" + e + '}';
        }
    }

    public static void main(String[] args) {
        CircleLinkedList<Integer> circleLinkedList = new CircleLinkedList<>();
        circleLinkedList.exitCircle(1, 2, 5);
    }
}
