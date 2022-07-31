package com.leetcode.competition.weekly.w304;

import java.util.*;

/**
 * 图中的最长环
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-31
 */
public class Solution6135 {
    private final Set<Integer> set = new HashSet<>();
    private int maxSize = -1;

    public int longestCycle(int[] edges) {
        this.set.clear();
        this.maxSize = -1;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1 && !set.contains(i)) {
                List<Integer> route = new ArrayList<>();
                route.add(i);
                boolean[] visited = new boolean[edges.length];
                visited[i] = true;
                dfs(edges, i, route, visited);
            }
        }
        return maxSize;
    }

    /**
     * 没有优化BFS 超时
     */
    private int maxSizeCycleBFS(int[] edges, int node) {
        int maxSize = -1;
        int[] distances = new int[edges.length];
        distances[node] = 0;
        boolean[] visited = new boolean[edges.length];
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int startNode = queue.remove();
                int endNode = edges[startNode];
                if (endNode != -1 && visited[endNode]) {
                    maxSize = Math.max(maxSize, distances[startNode] + 1 - distances[endNode]);
                    set.add(startNode);
                    set.add(endNode);
                } else if (endNode != -1 && !visited[endNode]) {
                    distances[endNode] = distances[startNode] + 1;
                    queue.add(endNode);
                    visited[endNode] = true;
                }
            }
        }
        return maxSize;
    }

    /**
     * DFS + 剪枝
     */
    private void dfs(int[] edge, int node, List<Integer> route, boolean[] visited) {
        int endNode = edge[node];
        if (set.contains(endNode)) {
            set.add(node);
            return;
        }
        if (endNode != -1 && !visited[endNode]) {
            visited[endNode] = true;
            route.add(endNode);
            dfs(edge, endNode, route, visited);
        } else if (endNode != -1 && visited[endNode]) {
            int i = route.indexOf(endNode);
            maxSize = Math.max(route.size() - i, maxSize);
            set.addAll(route);
        }
    }

    public static void main(String[] args) {
        Solution6135 solution6135 = new Solution6135();
        System.out.println(solution6135.longestCycle(new int[]{3, 3, 4, 2, 3}));
        System.out.println(solution6135.longestCycle(new int[]{2, -1, 3, 1}));
    }
}
