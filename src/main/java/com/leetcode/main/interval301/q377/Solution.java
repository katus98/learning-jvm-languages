package com.leetcode.main.interval301.q377;

/**
 * 组合总和 Ⅳ
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-12
 */
public class Solution {
    /**
     * DP 目标值是i的组合总数
     * d1DP: dp[i] += dp[i - num]
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
