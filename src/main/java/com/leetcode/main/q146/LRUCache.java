package com.leetcode.main.q146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 缓存
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-26
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        // 设置链表顺序为访问顺序
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * 移除最老元素的触发条件
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}
