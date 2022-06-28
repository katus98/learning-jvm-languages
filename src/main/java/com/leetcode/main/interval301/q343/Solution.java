package com.leetcode.main.interval301.q343;

/**
 * 整数拆分
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-09
 * @see com.leetcode.offer.q14.Solution
 */
public class Solution {
    /**
     * 贪心或者数学推导
     */
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        else if (n == 4) return n;
        int b = n / 3, a = n % 3;
        switch (a) {
            case 0:
                return (int) Math.pow(3, b);
            case 1:
                return ((int) Math.pow(3, b - 1)) * 4;
            case 2:
                return ((int) Math.pow(3, b)) * 2;
        }
        return 1;
    }

    /**
     * DP: 表示i对应的拆分最大乘积
     * DP: 实际上就是在一直获取最大值j * (i - j)即i-j不拆分 j * dp[i - j]即i-j继续拆分
     * 为什么分两种情况, 因为如果i-j不能继续拆分的话dp[i - j]相对实际结果会变小例如0, 1, 2几种情况
     * d1DP: dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]))
     */
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
