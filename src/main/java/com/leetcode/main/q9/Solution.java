package com.leetcode.main.q9;

/**
 * 回文数
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-27
 */
public class Solution {
    /**
     * 转换为字符串, 首尾判断相等
     */
    public boolean isPalindrome(int x) {
        char[] chs = String.valueOf(x).toCharArray();
        for (int i = 0; i < chs.length / 2; i++) {
            if (chs[i] != chs[chs.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
