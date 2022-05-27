package com.leetcode.main.interval501.q557;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        int last = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                reverseString(chs, last, i - 1);
                last = i + 1;
            } else if (i == chs.length - 1) {
                reverseString(chs, last, i);
            }
        }
        return new String(chs);
    }

    private void reverseString(char[] chs, int i, int j) {
        char temp;
        while (i < j) {
            temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
    }
}
