package com.leetcode.main.q344;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {

    /**
     * 双指针
     */
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char temp;
        while (i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
