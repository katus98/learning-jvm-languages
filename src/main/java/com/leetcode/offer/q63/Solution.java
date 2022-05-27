package com.leetcode.offer.q63;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-24
 * @see com.leetcode.main.interval101.q121.Solution
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            if (price - minPrice > maxPro) {
                maxPro = price - minPrice;
            }
        }
        return maxPro;
    }
}
