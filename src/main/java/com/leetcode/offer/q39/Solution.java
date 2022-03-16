package com.leetcode.offer.q39;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 */
public class Solution {
    /**
     * 哈希表统计数量
     */
    public int majorityElement(int[] nums) {
        int n = nums.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (n <= entry.getValue()) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 排序之后返回中位数
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
