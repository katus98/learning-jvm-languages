package com.leetcode.main.interval1001.q1046;

import java.util.PriorityQueue;

/**
 * 最后一块石头的重量
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-28
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() >= 2) {
            int bigger = queue.poll();
            int smaller = queue.poll();
            int left = bigger - smaller;
            if (left != 0) queue.offer(left);
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
