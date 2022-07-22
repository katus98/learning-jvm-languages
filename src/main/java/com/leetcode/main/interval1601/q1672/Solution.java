package com.leetcode.main.interval1601.q1672;

/**
 * 最富有客户的资产总量
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-22
 */
public class Solution {
    /**
     * 双层循环
     */
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0, sum;
        for (int[] account : accounts) {
            sum = 0;
            for (int money : account) {
                sum += money;
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
