package com.leetcode.main.interval301.q380;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-11
 */
public class RandomizedSet {
    /**
     * 记录元素在list中的位置
     */
    private final Map<Integer, Integer> map;
    /**
     * 记录元素
     */
    private final List<Integer> list;
    private final Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        this.map.put(val, list.size());
        this.list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        // 将最后一个位置的元素放到即将删除的位置
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        this.list.set(index, last);
        // 更新最后元素的位置信息
        this.map.put(last, index);
        // 移除最后的旧元素
        this.list.remove(list.size() - 1);
        // 移除哈希表里面val元素记录
        this.map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
