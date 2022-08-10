package com.leetcode.main.interval201.q210;

import java.util.*;

/**
 * 课程表 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-10
 */
public class Solution {
    private final Map<Integer, List<Integer>> graphMap = new HashMap<>();
    private final List<Integer> resOrder = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        this.graphMap.clear();
        for (int i = 0; i < numCourses; i++) {
            graphMap.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graphMap.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }
        this.resOrder.clear();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.remove();
            resOrder.add(node);
            for (int i : graphMap.get(node)) {
                inDegrees[i]--;
                if (inDegrees[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return resOrder.size() == numCourses ? resOrder.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

    private int[] visited;
    private boolean valid;
    private int index;
    private int[] result;

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        this.visited = new int[numCourses];
        this.valid = true;
        this.index = numCourses - 1;
        this.graphMap.clear();
        for (int i = 0; i < numCourses; i++) {
            graphMap.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graphMap.get(prerequisite[1]).add(prerequisite[0]);
        }
        this.result = new int[numCourses];
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) dfs(i);
        }
        return valid ? result : new int[0];
    }

    private void dfs(int node) {
        visited[node] = 1;
        for (int v : graphMap.get(node)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) return;
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        result[index--] = node;
        visited[node] = 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOrder2(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(solution.findOrder2(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
