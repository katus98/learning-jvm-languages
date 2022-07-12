package com.leetcode.main.interval201.q279;

/**
 * 完全平方数
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-12
 */
public class Solution {
    /**
     * DP
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
