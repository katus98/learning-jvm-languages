package com.nx.ds.linked;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * 单链表
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-26
 */
public class SingleLinkedList<E> {
    private Node dummyHead;
    private int size;

    public SingleLinkedList() {
        this.dummyHead = new Node();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Illegal index!");
        }
        Node prev = dummyHead;
        int i = 0;
        while (++i <= index) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        indexCheck(index);
        Node current = dummyHead.next;
        int i = 0;
        while (++i <= index) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void set(int index, E e) {
        indexCheck(index);
        Node current = dummyHead.next;
        int i = 0;
        while (++i <= index) {
            current = current.next;
        }
        current.e = e;
    }

    public E remove(int index) {
        indexCheck(index);
        Node prev = dummyHead;
        int i = 0;
        while (++i <= index) {
            prev = prev.next;
        }
        E result = prev.next.e;
        prev.next = prev.next.next;
        size--;
        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void remove(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                prev.next = prev.next.next;
                size--;
                break;
            }
            prev = prev.next;
        }
    }

    public void reverse() {
        Node root = new Node();
        Node node = dummyHead.next;
        while (node != null) {
            Node newNode = new Node(node.e);
            newNode.next = root.next;
            root.next = newNode;
            node = node.next;
        }
        this.dummyHead = root;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SingleLinkedList{DummyHead");
        Node current = dummyHead.next;
        while (current != null) {
            sb.append("->").append(current);
            current = current.next;
        }
        return sb.append("}").toString();
    }

    private void indexCheck(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Illegal index!");
        }
    }

    @Test
    void test() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        System.out.println(linkedList);
        linkedList.reverse();
        System.out.println(linkedList);
    }
}
