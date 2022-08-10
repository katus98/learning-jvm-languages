package com.leetcode.main.interval801.q815;

import java.util.*;

/**
 * 公交路线
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-10
 */
public class Solution {
    /**
     * 按照站点构建图, 图过大超时
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (target == source) return 0;
        int maxPos = -1;
        List<Set<Integer>> routeList = new ArrayList<>();
        for (int[] route : routes) {
            Set<Integer> set = new HashSet<>();
            for (int i : route) {
                maxPos = Math.max(i, maxPos);
                set.add(i);
            }
            routeList.add(set);
        }
        int n = maxPos + 1;
        int[] costs = new int[n];
        Arrays.fill(costs, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        costs[source] = 0;
        Set<Integer> nexSet = new HashSet<>();
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (Set<Integer> set : routeList) {
                if (set.contains(node)) {
                    nexSet.addAll(set);
                }
            }
            for (int end : nexSet) {
                if (costs[end] == -1 || costs[end] > costs[node] + 1) {
                    costs[end] = costs[node] + 1;
                    queue.add(end);
                }
            }
        }
        return costs[target];
    }

    /**
     * 构建线路之间的图 + BFS
     */
    public int numBusesToDestination2(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        // 线路连通性
        boolean[][] edge = new boolean[n][n];
        // <站点, 当前站点所在的线路>
        Map<Integer, List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {   // 每一条线路
            for (int site : routes[i]) {   // 当前线路上的每个站点
                List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }
        // 按照线路计算距离
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<>();
        for (int bus : rec.getOrDefault(source, new ArrayList<>())) {
            dis[bus] = 1;
            que.offer(bus);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        // 目标站点所在线路的最小距离
        for (int bus : rec.getOrDefault(target, new ArrayList<>())) {
            if (dis[bus] != -1) {
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
