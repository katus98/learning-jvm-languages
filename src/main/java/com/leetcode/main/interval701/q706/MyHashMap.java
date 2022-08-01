package com.leetcode.main.interval701.q706;

import java.util.LinkedList;

/**
 * 设计哈希映射
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-01
 */
public class MyHashMap {
    /**
     * 可以设计哈希桶是固定大小的
     */
    private static final int SIZE = 769;
    private final LinkedList<Node>[] array;

    public MyHashMap() {
        this.array = new LinkedList[SIZE];
    }

    public void put(int key, int value) {
        int index = key % SIZE;
        if (array[index] == null) {
            array[index] = new LinkedList<>();
        }
        boolean flag = false;
        for (Node node : array[index]) {
            if (node.key == key) {
                node.value = value;
                flag = true;
                break;
            }
        }
        if (!flag) {
            array[index].add(new Node(key, value));
        }
    }

    public int get(int key) {
        int index = key % SIZE;
        if (array[index] == null) {
            return -1;
        }
        for (Node node : array[index]) {
            if (node.key == key) return node.value;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;
        if (array[index] != null) {
            array[index].removeIf(node -> node.key == key);
        }
    }

    public static class Node {
        private final int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
