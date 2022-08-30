package com.leetcode.main.interval1601.q1630;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 等差子数组
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-30
 */
public class Solution {
    /**
     * 优先队列
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];
            for (int j = left; j <= right; j++) {
                queue.offer(nums[j]);
            }
            int last = queue.poll(), delta = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                if (delta == Integer.MAX_VALUE) {
                    delta = queue.peek() - last;
                } else {
                    if (queue.peek() - last != delta) {
                        list.add(false);
                        break;
                    }
                }
                last = queue.poll();
            }
            if (queue.isEmpty()) {
                list.add(true);
            } else {
                queue.clear();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }
}
