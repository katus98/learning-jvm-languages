package com.leetcode.competition.weekly.w304;

/**
 * 分组的最大数量
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-31
 */
public class Solution6133 {
    public int maximumGroups(int[] grades) {
        int lastSize = 0, otherSize = grades.length - lastSize, i;
        for (i = 1; i < grades.length; i++) {
            lastSize = i;
            otherSize -= lastSize;
            if (otherSize < i + 1) break;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution6133 solution6133 = new Solution6133();
        System.out.println(solution6133.maximumGroups(new int[]{47, 2, 16, 17, 41, 4, 38, 23, 47}));
    }
}
