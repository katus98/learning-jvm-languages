package com.leetcode.main.interval1.q53;

/**
 * 最大子数组和
 * 动态规划
 * dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-15
 * @see com.leetcode.offer.q42.Solution
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (maxSum < dp[i]) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
}
