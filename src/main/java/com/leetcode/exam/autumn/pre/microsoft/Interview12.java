package com.leetcode.exam.autumn.pre.microsoft;

import java.util.Arrays;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-22
 */
public class Interview12 {
    public int maxHeight(int[][] blocks) {
        if (blocks.length <= 1) return blocks.length;
        Arrays.sort(blocks, (o1, o2) -> {
            int c = Integer.compare(o1[0], o2[0]);
            if (c != 0) {
                return c;
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int[] dp = new int[blocks.length];
        dp[0] = 1;
        int maxH = 1;
        for (int i = 1; i < blocks.length; i++) {
            for (int j = 0; j < i; j++) {
                if (blocks[j][1] < blocks[i][1] && blocks[j][0] < blocks[i][0] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    maxH = Math.max(maxH, dp[i]);
                }
            }
        }
        return maxH;
    }

    public static void main(String[] args) {
        Interview12 interview12 = new Interview12();
        System.out.println(interview12.maxHeight(new int[][]{{1, 2}, {3, 4}, {1, 1}, {4, 1}}));
        System.out.println(interview12.maxHeight(new int[][]{{1, 2}, {3, 4}, {1, 1}, {4, 5}, {4, 1}}));
    }
}
