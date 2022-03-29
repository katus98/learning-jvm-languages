package com.leetcode.main.q146;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 * 设置双向链表和哈希表
 * 双向链表越靠前说明越新访问过, 设置每次访问都把相应的节点放到链表头
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-26
 */
public class LRUCache2 {
    private final Map<Integer, Node> map;
    private final int capacity;
    private final Node dummyHead, dummyTail;

    public LRUCache2(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.dummyHead = new Node(-1, -1);
        this.dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            update(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            update(key);
            return;
        }
        if (map.size() == capacity) {
            map.remove(dummyTail.prev.key);
            Node prev = dummyTail.prev.prev;
            prev.next = dummyTail;
            dummyTail.prev = prev;
        }
        Node node = new Node(key, value);
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next = node;
        node.next.prev = node;
        map.put(key, node);
    }

    private void update(int key) {
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        prev = dummyHead;
        next = dummyHead.next;
        prev.next = node;
        next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    public static class Node {
        private Node prev, next;
        private final int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
