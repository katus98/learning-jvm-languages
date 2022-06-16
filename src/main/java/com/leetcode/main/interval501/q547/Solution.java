package com.leetcode.main.interval501.q547;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 省份数量
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-16
 */
public class Solution {
    /**
     * DFS
     */
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && !visited[i]) {
                    dfs(isConnected, visited, i);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                dfs(isConnected, visited, j);
            }
        }
    }

    /**
     * BFS
     */
    public int findCircleNum2(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int index = queue.remove();
                    visited[index] = true;
                    for (int j = 0; j < isConnected.length; j++) {
                        if (!visited[j] && isConnected[index][j] == 1) {
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}
