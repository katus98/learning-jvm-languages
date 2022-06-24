package com.leetcode.main.interval201.q213;

/**
 * 打家劫舍 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-03
 */
public class Solution {
    /**
     * 因为首尾不能共存, 所以分别做[0,n-2]和[1,n-1]的区间然后取最大值即可
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
        }
        return dp[end - start];
    }
}
