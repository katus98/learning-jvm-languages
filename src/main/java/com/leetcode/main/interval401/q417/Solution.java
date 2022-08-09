package com.leetcode.main.interval401.q417;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 太平洋大西洋水流问题
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-09
 */
public class Solution {
    private int m, n;
    private int[][] heights;

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    /**
     * 逆向思维 + dfs
     * 从海的边界向高处流, 然后求交集
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = m > 0 ? heights[0].length : 0;
        Set<List<Integer>> pacificSet = new HashSet<>();
        Set<List<Integer>> atlanticSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificSet);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacificSet);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlanticSet);
        }
        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, atlanticSet);
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (List<Integer> cors : pacificSet) {
            if (atlanticSet.contains(cors)) {
                resList.add(cors);
            }
        }
        return resList;
    }

    private void dfs(int i, int j, Set<List<Integer>> set) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        if (set.contains(list)) return;
        set.add(list);
        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (valid(ni, nj) && heights[ni][nj] >= heights[i][j]) {
                dfs(ni, nj, set);
            }
        }
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
