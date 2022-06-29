package com.leetcode.main.interval101.q121;

/**
 * 买卖股票的最佳时机
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-14
 * @see com.leetcode.offer.q63.Solution
 */
public class Solution {
    /**
     * 遍历整个序列, 最大利润一定出现在当前价格卖出, 当前之前的最低价格买入
     */
    public int maxProfit(int[] prices) {
        int minMoney = Integer.MAX_VALUE;   // i天之前的历史最低价
        int maxProfit = Integer.MIN_VALUE;   // 当前的最大利润
        for (int price : prices) {
            if (price < minMoney) {
                minMoney = price;
            }
            if (price - minMoney > maxProfit) {
                maxProfit = price - minMoney;
            }
        }
        return Math.max(maxProfit, 0);
    }
}
