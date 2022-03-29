package com.leetcode.main.q215;

import java.util.PriorityQueue;

/**
 * 数组中第 k 个最大元素
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-29
 */
public class Solution {
    /**
     * 暴力解法, 最大堆, 排出第k个
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int num : nums) {
            queue.offer(num);
        }
        int x = 0;
        for (int i = 0; i < k; i++) {
            x = queue.poll();
        }
        return x;
    }
    /**
     * 维护容量为k的最小堆, 最终堆顶就是答案
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num >= queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.peek();
    }
}
