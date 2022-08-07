package com.leetcode.competition.weekly.w305;

import java.util.Arrays;

/**
 * 最长理想子序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-07
 */
public class Solution6138 {
    /**
     * d1DP: 超时
     * 以当前元素结尾的最长理想子序列长度
     */
    public int longestIdealString(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i] > j + 1) break;
                char ch2 = s.charAt(j);
                if (Math.abs(ch - ch2) <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxSize = Math.max(maxSize, dp[i]);
        }
        return maxSize;
    }

    /**
     * d1DP: 以特定字母为结尾的最长理想子序列长度
     */
    public int longestIdealString2(String s, int k) {
        int[] dp = new int[26];
        int maxSize = 1;
        for (int i = 0; i < s.length(); i++) {
            int t = 0;
            char ch = s.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (Math.abs(ch - c) <= k) {
                    t = Math.max(t, dp[c - 'a'] + 1);
                }
            }
            dp[ch - 'a'] = t;
            maxSize = Math.max(maxSize, dp[ch - 'a']);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        Solution6138 solution6138 = new Solution6138();
        System.out.println(solution6138.longestIdealString("pvjcci", 4));
    }
}
