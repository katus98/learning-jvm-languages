package com.leetcode.main.interval1.q91;

/**
 * 解码方法
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-19
 */
public class Solution {
    /**
     * DP 表示长度为i的s前缀所能形成的解码个数
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            char ch = s.charAt(i - 1);
            if (ch >= '1' && ch <= '9') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                char ch1 = s.charAt(i - 2);
                char ch2 = s.charAt(i - 1);
                if ((ch1 == '1' && ch2 >= '0' && ch2 <= '9') || (ch1 == '2' && ch2 >= '0' && ch2 <= '6')) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * DFS, 超时
     */
    private int decode(String s, int i) {
        int count = 0;
        if (i == s.length()) {
            count++;
        }
        if (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '1' && ch <= '9') {
                count += decode(s, i + 1);
            }
        }
        if (i + 1 < s.length()) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            if ((ch1 == '1' && ch2 >= '0' && ch2 <= '9') || (ch1 == '2' && ch2 >= '0' && ch2 <= '6')) {
                count += decode(s, i + 2);
            }
        }
        return count;
    }
}
