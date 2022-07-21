package com.leetcode.main.interval401.q456;

import java.util.TreeMap;

/**
 * 132 模式
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-21
 */
public class Solution {
    /**
     * 遍历中间值
     * 始终维护左侧最小值, 右侧指放入TreeMap保证顺序
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAllMap = new TreeMap<>();
        for (int k = 2; k < n; ++k) {
            rightAllMap.put(nums[k], rightAllMap.getOrDefault(nums[k], 0) + 1);
        }
        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAllMap.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            int value = rightAllMap.get(nums[j + 1]) - 1;
            if (value == 0) {
                rightAllMap.remove(nums[j + 1]);
            } else {
                rightAllMap.put(nums[j + 1], value);
            }
        }
        return false;
    }
}
