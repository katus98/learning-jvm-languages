package com.leetcode.main.interval1201.q1221;

import java.util.Arrays;

/**
 * 分割平衡字符串
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-05
 */
public class Solution {
    /**
     * 单指针统计字符数量
     */
    public int balancedStringSplit(String s) {
        int[] counts = new int[2];
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                counts[0]++;
            } else {
                counts[1]++;
            }
            if (counts[0] == counts[1]) {
                maxSize++;
                Arrays.fill(counts, 0);
            }
        }
        return maxSize;
    }
}
