package com.leetcode.main.interval301.q392;

/**
 * 判断子序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-10
 */
public class Solution {
    /**
     * 双指针
     */
    public boolean isSubsequence(String s, String t) {
        if (s.equals(t) || s.isEmpty()) return true;
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i == s.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
    }
}
