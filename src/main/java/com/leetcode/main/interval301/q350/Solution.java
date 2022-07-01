package com.leetcode.main.interval301.q350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-01
 */
public class Solution {
    /**
     * 哈希表
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int num = entry.getKey();
            if (map2.containsKey(num)) {
                int count = Math.min(entry.getValue(), map2.get(num));
                for (int i = 0; i < count; i++) {
                    list.add(num);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
