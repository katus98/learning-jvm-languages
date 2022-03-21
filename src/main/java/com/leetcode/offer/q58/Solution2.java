package com.leetcode.offer.q58;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-20
 */
public class Solution2 {

    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords2(String s, int n) {
        n = n % s.length();
        char[] chars = s.toCharArray();
        reserve(chars, 0, s.length());
        reserve(chars, 0, s.length() - n);
        reserve(chars, s.length() - n, s.length());
        return new String(chars);
    }

    /**
     * 反转字符串
     */
    private void reserve(char[] chars, int i, int j) {
        char[] clone = chars.clone();
        for (int k = i; k < j; k++) {
            chars[k] = clone[i + j - k - 1];
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.reverseLeftWords2("abcdefgh", 2));
    }
}
