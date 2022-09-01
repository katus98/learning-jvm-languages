package com.leetcode.main.interval1301.q1376;

/**
 * 通知所有员工所需的时间
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-01
 */
public class Solution {
    /**
     * 原生DFS: 从叶子节点向根节点遍历
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, headID, manager, informTime));
        }
        return res;
    }

    private int dfs(int i, int headID, int[] manager, int[] informTime) {
        if (i == headID) {
            return informTime[i];
        }
        return informTime[i] + dfs(manager[i], headID, manager, informTime);
    }

    /**
     * 原生DFS + 记忆化搜索
     */
    private int[] resArr;   // 用一个数组记录曾经在dfs中计算的中间结果

    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        this.resArr = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs2(i, headID, manager, informTime));
        }
        return res;
    }

    private int dfs2(int i, int headID, int[] manager, int[] informTime) {
        if (i == headID) {
            return informTime[i];
        }
        // 如果记忆数组里面存在结果直接返回
        if (resArr[i] != 0) {
            return resArr[i];
        }
        // 记住计算出来的结果
        int x = informTime[i] + dfs2(manager[i], headID, manager, informTime);
        resArr[i] = x;
        return x;
    }
}
