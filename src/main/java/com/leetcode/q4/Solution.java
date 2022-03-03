package com.leetcode.q4;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {

    public String longestPalindrome(String s) {
        String maxSub = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String current = s.substring(i, j);
                if (current.length() > maxSub.length() && isPalindromic(current)) {
                    maxSub = current;
                }
            }
        }
        return maxSub;
    }

    private boolean isPalindromic(String str) {
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
