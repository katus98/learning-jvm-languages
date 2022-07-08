package com.leetcode.main.interval1.q5;

/**
 * 最长回文子串
 * 中心扩散法, 选定中心, 两侧每次增加一个, 注意中心可能是字符, 也可能是字符中间
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-14
 */
public class Solution {
    private int length;

    public String longestPalindrome(String s) {
        this.length = s.length();
        String result = "";
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; isValid(i - j) && isValid(i + j) && s.charAt(i - j) == s.charAt(i + j); j++) {
                if (2 * j + 1 > count) {
                    result = s.substring(i - j, i + j + 1);
                    count = 2 * j + 1;
                }
            }
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; isValid(i - j) && isValid(i + j + 1) && s.charAt(i - j) == s.charAt(i + j + 1); j++) {
                if (2 * j + 2 > count) {
                    result = s.substring(i - j, i + j + 2);
                    count = 2 * j + 2;
                }
            }
        }
        return result;
    }

    public String longestPalindrome2(String s) {
        if (s.length() < 2) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1, begin = 0;
        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private boolean isValid(int index) {
        return index >= 0 && index < length;
    }
}
