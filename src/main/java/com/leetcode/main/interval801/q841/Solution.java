package com.leetcode.main.interval801.q841;

import java.util.List;

/**
 * 钥匙和房间
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-19
 */
public class Solution {
    private int count = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.count = 0;
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        return count == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        visited[i] = true;
        count++;
        for (int room : rooms.get(i)) {
            if (!visited[room]) {
                dfs(rooms, visited, room);
            }
        }
    }
}
