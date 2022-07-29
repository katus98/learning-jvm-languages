package com.leetcode.main.interval701.q787;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * K 站中转内最便宜的航班
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-29
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k, src, 0});
        while (!queue.isEmpty()) {
            int[] startPoint = queue.poll();
            if (startPoint[0] < 0) break;
            int[] endPoints = graph[startPoint[1]];
            for (int i = 0; i < endPoints.length; i++) {
                int thePrice = endPoints[i];
                if (thePrice > 0) {
                    int price = thePrice + startPoint[2];
                    if (price < result[i]) {
                        result[i] = price;
                        queue.add(new int[]{startPoint[0] - 1, i, price});
                    }
                }
            }
        }
        return result[dst] == Integer.MAX_VALUE ? -1 : result[dst];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
    }
}
