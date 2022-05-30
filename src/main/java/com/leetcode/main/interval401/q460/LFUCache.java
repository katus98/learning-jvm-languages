package com.leetcode.main.interval401.q460;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * LFU 缓存
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-30
 */
public class LFUCache {
    private final Map<Integer, Node> map;
    private final TreeSet<Node> set;
    private final int capacity;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.set = new TreeSet<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            set.remove(node);
            node.count++;
            node.time = System.nanoTime();
            set.add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            set.remove(node);
            node.value = value;
            node.count++;
            node.time = System.nanoTime();
        } else {
            node = new Node(key, value);
            if (map.size() == capacity) {
                Node oldNode = set.first();
                set.remove(oldNode);
                map.remove(oldNode.key);
            }
            map.put(key, node);
        }
        set.add(node);
    }

    public static class Node implements Comparable<Node> {
        private final int key;
        private int value;
        private int count;
        private long time;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
            this.time = System.nanoTime();
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Node && key == ((Node) obj).key;
        }

        @Override
        public int compareTo(Node o) {
            return count == o.count ? Long.compare(time, o.time) : Integer.compare(count, o.count);
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
