package com.leetcode.main.interval501.q509;

/**
 * 斐波那契数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-22
 */
public class Solution {
    /**
     * 最简单的一维动态规划
     * dp[i] = dp[i - 1] + dp[i - 2]
     */
    public int fib(int n) {
        int[] dp = new int[Math.max(2, n + 1)];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 翻滚数组
     */
    public int fib2(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, t = 0;
        for (int i = 2; i <= n; i++) {
            t = a + b;
            a = b;
            b = t;
        }
        return t;
    }
}
