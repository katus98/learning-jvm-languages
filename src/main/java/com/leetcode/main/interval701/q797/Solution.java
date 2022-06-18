package com.leetcode.main.interval701.q797;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的路径
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-18
 */
public class Solution {
    private int n = 0;
    private boolean[] visited;
    private final List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.n = graph.length;
        this.visited = new boolean[n];
        this.resList.clear();
        visited[0] = true;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path);
        return resList;
    }

    /**
     * DFS + 回溯
     */
    private void dfs(int[][] graph, int i, List<Integer> path) {
        if (i == n - 1) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int dest : graph[i]) {
            if (!visited[dest]) {
                path.add(dest);
                visited[dest] = true;
                dfs(graph, dest, path);
                visited[dest] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}).forEach(list -> {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }
}
