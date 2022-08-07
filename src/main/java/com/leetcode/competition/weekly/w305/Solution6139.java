package com.leetcode.competition.weekly.w305;

import java.util.*;

/**
 * 受限条件下可到达节点的数目
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-07
 */
public class Solution6139 {
    /**
     * 全部构成图, 占用过大空间
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrictedSet = new HashSet<>();
        for (int i : restricted) {
            restrictedSet.add(i);
        }
        boolean[] visited = new boolean[n];
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited[node] = true;
            count++;
            for (int i = 0; i < n; i++) {
                if (graph[node][i] && !visited[i] && !restrictedSet.contains(i)) {
                    queue.add(i);
                }
            }
        }
        return count;
    }

    /**
     * 仅构成非限制节点的图结构
     */
    public int reachableNodes2(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrictedSet = new HashSet<>();
        for (int i : restricted) {
            restrictedSet.add(i);
        }
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!restrictedSet.contains(i)) {
                graphMap.put(i, new ArrayList<>());
            }
        }
        for (int[] edge : edges) {
            if (!restrictedSet.contains(edge[0]) && !restrictedSet.contains(edge[1])) {
                graphMap.get(edge[0]).add(edge[1]);
                graphMap.get(edge[1]).add(edge[0]);
            }
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited[node] = true;
            count++;
            List<Integer> destNodes = graphMap.get(node);
            for (int destNode : destNodes) {
                if (!visited[destNode]) {
                    queue.add(destNode);
                }
            }
        }
        return count;
    }
}
