package com.leetcode.competition.weekly.w304;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 找到离给定两个节点最近的节点
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-31
 */
public class Solution6134 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map1 = calAllRoute(edges, node1);
        Map<Integer, Integer> map2 = calAllRoute(edges, node2);
        int minDisBigger = Integer.MAX_VALUE, resNode = -1;
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            int endNode = entry1.getKey();
            int dis1 = entry1.getValue();
            if (map2.containsKey(endNode)) {
                int dis2 = map2.get(endNode);
                if (Math.max(dis1, dis2) < minDisBigger) {
                    minDisBigger = Math.max(dis1, dis2);
                    resNode = endNode;
                } else if (Math.max(dis1, dis2) == minDisBigger && resNode > endNode) {
                    resNode = endNode;
                }
            }
        }
        return resNode;
    }

    private Map<Integer, Integer> calAllRoute(int[] edges, int node) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(node, 0);
        boolean[] visited = new boolean[edges.length];
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int startNode = queue.remove();
                int endNode = edges[startNode];
                if (endNode != -1 && !visited[endNode]) {
                    map.put(endNode, map.get(startNode) + 1);
                    queue.add(endNode);
                    visited[endNode] = true;
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Solution6134 solution6134 = new Solution6134();
        System.out.println(solution6134.closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));
        System.out.println(solution6134.closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
    }
}
