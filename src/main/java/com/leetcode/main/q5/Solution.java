package com.leetcode.main.q5;

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

    private boolean isValid(int index) {
        return index >= 0 && index < length;
    }
}
