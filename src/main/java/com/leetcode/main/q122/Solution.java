package com.leetcode.main.q122;

/**
 * 买卖股票的最佳时机 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-05
 */
public class Solution {
    /**
     * dp
     * 第i天不持有股票的最大利润是前一天不持有股票的最大利润和前一天持有股票今天卖出的最大值
     * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
     * 第i天持有股票的最大利润是前一天持有股票的最大利润和前一天没股票今天买入的最大值
     * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 换位思考
     * 最大利润实际上就是每个涨价的时候都卖出
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
