package com.leetcode.main.interval201.q207;

import java.util.*;

/**
 * 课程表
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-03
 */
public class Solution {
    private final Map<Integer, List<Integer>> edges = new HashMap<>();
    private int[] visited;   // 搜索状态 0 尚未搜索 1 正在搜索 2 完成搜索
    private boolean valid;   // 是否有环

    /**
     * 深度优先搜索
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.edges.clear();
        for (int i = 0; i < numCourses; i++) {
            edges.put(i, new ArrayList<>());
        }
        this.visited = new int[numCourses];
        this.valid = true;
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) dfs(i);
        }
        return valid;
    }

    private void dfs(int node) {
        // 开始搜索
        visited[node] = 1;
        for (int childNode : edges.get(node)) {
            if (visited[childNode] == 0) {
                // 如果遍历的节点没有搜索过
                dfs(childNode);   // 进入搜索
                if (!valid) return;   // 如果有环直接退出
            } else if (visited[childNode] == 1) {
                // 如果遍历的节点正在被搜索, 说明这轮搜索重复到了同一个节点
                valid = false;   // 存在环
                return;
            }
        }
        // 完成搜索
        visited[node] = 2;
    }

    private int[] inDegrees;

    /**
     * 广度优先搜索
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        this.edges.clear();
        for (int i = 0; i < numCourses; ++i) {
            edges.put(i, new ArrayList<>());
        }
        this.inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            ++inDegrees[prerequisite[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int node = queue.poll();
            for (int childNode : edges.get(node)) {
                --inDegrees[childNode];
                if (inDegrees[childNode] == 0) {
                    queue.offer(childNode);
                }
            }
        }
        // 如果每个节点都被遍历到了
        return visited == numCourses;
    }
}
