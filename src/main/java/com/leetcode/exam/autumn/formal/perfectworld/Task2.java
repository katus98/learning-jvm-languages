package com.leetcode.exam.autumn.formal.perfectworld;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-08
 */
public class Task2 {
    private int wholeCost = 0;
    private List[] graph;
    private int count = 0;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.wholeCost = 0;
        this.count = 0;
        this.graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<int[]>();
        }
        for (int[] time : times) {
            int start = time[0] - 1;
            int end = time[1] - 1;
            int cost = time[2];
            graph[start].add(new int[]{end, cost});
        }
        for (int i = 0; i < n; i++) {
            graph[i].sort((o1, o2) -> {
                if (o1 instanceof int[] && o2 instanceof int[]) {
                    int[] i1 = (int[]) o1;
                    int[] i2 = (int[]) o2;
                    if (i1.length == 2 && i2.length == 2) {
                        return Integer.compare(i1[1], i2[1]);
                    }
                }
                return 0;
            });
        }
        boolean[] visited = new boolean[n];
        int[] resList = new int[n];
        Arrays.fill(resList, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k - 1);
        resList[k - 1] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Object o : graph[node]) {
                int[] item = (int[]) o;
                int end = item[0];
                int c = item[1];
                if (!visited[end] && (resList[end] == -1 || resList[end] > resList[node] + c)) {
                    resList[end] = resList[node] + c;
                    queue.add(end);
                }
            }
            visited[node] = true;
        }
        for (int i = 0; i < n; i++) {
            if (resList[i] == -1) return -1;
            wholeCost = Math.max(wholeCost, resList[i]);
        }
        return wholeCost;
    }

    private void dfs(int k, boolean[] visited, int cost) {
        visited[k] = true;
        this.count++;
        for (Object o : graph[k]) {
            int[] item = (int[]) o;
            int end = item[0];
            int c = item[1];
            if (!visited[end]) {
                wholeCost = Math.max(wholeCost, cost + c);
                dfs(end, visited, cost + c);
            }
        }
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        System.out.println(task2.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
}
