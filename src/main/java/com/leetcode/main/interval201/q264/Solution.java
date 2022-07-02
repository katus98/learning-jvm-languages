package com.leetcode.main.interval201.q264;

/**
 * 丑数 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-18
 * @see com.leetcode.offer.q49.Solution
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 记录乘2 3 5分别对应的最后一个丑数位置
        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 1; i < n; i++) {
            // 每次选择乘 2 3 5中的最小值
            dp[i] = Math.min(Math.min(2 * dp[n1], 3 * dp[n2]), 5 * dp[n3]);
            // 将选中的最小值的对应指针移动
            if (2 * dp[n1] == dp[i]) {
                n1++;
            }
            if (3 * dp[n2] == dp[i]) {
                n2++;
            }
            if (5 * dp[n3] == dp[i]) {
                n3++;
            }
        }
        return dp[n - 1];
    }
}
