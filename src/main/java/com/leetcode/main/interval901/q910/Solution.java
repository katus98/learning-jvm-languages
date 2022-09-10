package com.leetcode.main.interval901.q910;

import java.util.Arrays;

/**
 * 最小差值 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-03
 */
public class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int res = nums[nums.length - 1] - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int low = Math.min(nums[0] + k, nums[i + 1] - k);
            int high = Math.max(nums[nums.length - 1] - k, nums[i] + k);
            res = Math.min(res, high - low);
        }
        return res;
    }
}
