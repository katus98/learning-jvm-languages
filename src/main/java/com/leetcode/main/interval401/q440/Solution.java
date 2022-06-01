package com.leetcode.main.interval401.q440;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 字典序的第K小数字
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-01
 */
public class Solution {
    /**
     * 最大堆控制容量, 超时
     */
    public int findKthNumber(int n, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < n + 1; i++) {
            String str = String.valueOf(i);
            if (i <= k) {
                queue.offer(str);
                continue;
            }
            if (queue.peek().compareTo(str) > 0) {
                queue.poll();
                queue.offer(str);
            }
        }
        return Integer.parseInt(queue.peek());
    }

    /**
     * 构建字典树
     */
    public int findKthNumber2(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(13, 2));
    }
}
