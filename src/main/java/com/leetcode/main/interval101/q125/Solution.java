package com.leetcode.main.interval101.q125;

/**
 * 验证回文串
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-09
 */
public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                builder.append(ch);
            } else if (Character.isLetter(ch)) {
                builder.append(String.valueOf(ch).toLowerCase());
            }
        }
        String str = builder.toString();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
