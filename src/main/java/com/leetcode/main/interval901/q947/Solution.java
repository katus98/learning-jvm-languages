package com.leetcode.main.interval901.q947;

import java.util.ArrayList;
import java.util.List;

/**
 * 移除最多的同行或同列石头
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-19
 */
public class Solution {
    public int removeStones(int[][] stones) {
        int maxI = 0, maxJ = 0;
        for (int[] stone : stones) {
            maxI = Math.max(maxI, stone[0]);
            maxJ = Math.max(maxJ, stone[1]);
        }
        List[] rowList = new List[maxI + 1], colList = new List[maxJ + 1];
        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            if (rowList[stone[0]] == null) {
                rowList[stone[0]] = new ArrayList<Integer>();
            }
            rowList[stone[0]].add(i);
            if (colList[stone[1]] == null) {
                colList[stone[1]] = new ArrayList<Integer>();
            }
            colList[stone[1]].add(i);
        }
        boolean[] visited = new boolean[stones.length];
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                dfs(rowList, colList, visited, stones, i);
                count++;
            }
        }
        return stones.length - count;
    }

    private void dfs(List[] rowList, List[] colList, boolean[] visited, int[][] stones, int i) {
        visited[i] = true;
        int[] stone = stones[i];
        for (Object j : rowList[stone[0]]) {
            int n = (Integer) j;
            if (!visited[n]) {
                dfs(rowList, colList, visited, stones, n);
            }
        }
        for (Object j : colList[stone[1]]) {
            int n = (Integer) j;
            if (!visited[n]) {
                dfs(rowList, colList, visited, stones, n);
            }
        }
    }
}
