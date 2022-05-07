package com.leetcode.offer.q59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-21
 */
public class Solution {
    /**
     * 滑动窗口取最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            res[i] = queue.peek();
            queue.remove(nums[i]);
            if (j < nums.length - 1) queue.offer(nums[j + 1]);
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            // 当一个元素入队, 前面相对较小的元素就不会对max有影响了, 所以删除所有小的数值后入队
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            // 当一个元素入队, 前面相对较小的元素就不会对max有影响了, 所以删除所有小的数值后入队
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 当前滑动窗口已经到边界
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
