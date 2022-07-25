package com.leetcode.main.interval1301.q1309;

/**
 * 解码字母到整数映射
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-25
 */
public class Solution {
    public String freqAlphabets(String s) {
        char[] chs = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (i + 2 < s.length() && chs[i + 2] == '#') {
                builder.append(decode(chs, i, i + 2));
                i += 3;
            } else {
                builder.append(decode(chs, i, i));
                i++;
            }
        }
        return builder.toString();
    }

    private char decode(char[] chs, int i, int j) {
        int count = 0;
        char res = 'a';
        if (j > i) {
            count += 10 * (chs[i] - '0');
            count += chs[i + 1] - '0';
        } else {
            count += chs[i] - '0';
        }
        count--;
        res += count;
        return res;
    }
}
