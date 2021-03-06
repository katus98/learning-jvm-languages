package com.leetcode.main.interval701.q746;

/**
 * 使用最小花费爬楼梯
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-23
 */
public class Solution {
    /**
     * d1DP
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
