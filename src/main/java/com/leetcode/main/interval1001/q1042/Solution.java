package com.leetcode.main.interval1001.q1042;

import java.util.Arrays;

/**
 * 不邻接植花
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-29
 */
public class Solution {
    /**
     * 遍历每个节点的每条边, 填充一个不重复的数值
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        boolean[][] graph = new boolean[n][n];
        for (int[] path : paths) {
            graph[path[0] - 1][path[1] - 1] = true;
            graph[path[1] - 1][path[0] - 1] = true;
        }
        int[] answer = new int[n];
        boolean[] rss;
        for (int i = 0; i < n; i++) {
            rss = new boolean[4];
            boolean[] path = graph[i];
            for (int j = 0; j < path.length; j++) {
                if (path[j]) {
                    if (answer[j] != 0) {
                        rss[answer[j] - 1] = true;
                    }
                }
                int k = 0;
                while (rss[k]) k++;
                answer[i] = k + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}})));
    }
}
