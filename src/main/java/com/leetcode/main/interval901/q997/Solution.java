package com.leetcode.main.interval901.q997;

/**
 * 找到小镇的法官
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-18
 */
public class Solution {
    /**
     * 统计每个节点的入度和出度
     */
    public int findJudge(int n, int[][] trust) {
        int[] trustMap = new int[n], t2Map = new int[n];
        for (int[] ints : trust) {
            trustMap[ints[0] - 1]++;
            t2Map[ints[1] - 1]++;
        }
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (trustMap[i] == 0 && t2Map[i] == n - 1) {
                if (result == -1) {
                    result = i + 1;
                } else {
                    return -1;
                }
            }
        }
        return result;
    }
}
