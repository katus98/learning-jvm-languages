package com.leetcode.main.q53;

/**
 * 最大子数组和
 * 动态规划
 * dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-15
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            if (num > max) max = num;
        }
        return max;
    }
}
