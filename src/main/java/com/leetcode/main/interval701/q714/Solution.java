package com.leetcode.main.interval701.q714;

/**
 * 买卖股票的最佳时机含手续费
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-29
 * @see com.leetcode.main.interval101.q122.Solution
 */
public class Solution {
    /**
     * DP
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }
}
