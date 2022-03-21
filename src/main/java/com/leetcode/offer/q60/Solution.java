package com.leetcode.offer.q60;

import java.util.Arrays;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-21
 */
public class Solution {
    /**
     * DP: 从前向后推, n个骰子的概率实际上是n-1个骰子的概率的基础上每种情况的六分之一的和
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = j; k < j + 6; k++) {
                    tmp[k] += dp[j] * (1.0 / 6.0);
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
