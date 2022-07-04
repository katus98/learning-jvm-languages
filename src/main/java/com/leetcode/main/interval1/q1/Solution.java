package com.leetcode.main.interval1.q1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {
    /**
     * 暴力解法
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(res[0] + ":" + res[1]);
    }
}
