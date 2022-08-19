package com.leetcode.main.interval1501.q1557;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以到达所有点的最少点数目
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-19
 */
public class Solution {
    /**
     * 相当于统计入度为0的点
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegrees = new int[n];
        for (List<Integer> edge : edges) {
            inDegrees[edge.get(1)]++;
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                resList.add(i);
            }
        }
        return resList;
    }
}
