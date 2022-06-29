package com.leetcode.main.interval301.q309;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-29
 */
public class Solution {
    /**
     * DP
     * 持有股票则前一天持有股票/前一天没有未冻结今天买入
     * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i])
     * 不持有股票冻结说明前一天卖出了股票
     * dp[i][1] = dp[i - 1][0] + prices[i]
     * 不持有股票不冻结则是前一天不持有股票的最大值
     * dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2])
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        // 持有股票
        dp[0][0] = -prices[0];
        // 不持有股票且冻结
        dp[0][1] = 0;
        // 不持有股票且未冻结
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 持有股票则前一天持有股票/前一天没有未冻结今天买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 不持有股票冻结说明前一天卖出了股票
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 不持有股票不冻结则是前一天不持有股票的最大值
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
