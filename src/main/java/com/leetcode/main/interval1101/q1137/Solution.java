package com.leetcode.main.interval1101.q1137;

/**
 * 第 N 个泰波那契数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-22
 */
public class Solution {
    /**
     * 最基本的一维动态规划
     */
    public int tribonacci(int n) {
        int[] dp = new int[Math.max(3, n + 1)];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
