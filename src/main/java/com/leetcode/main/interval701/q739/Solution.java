package com.leetcode.main.interval701.q739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-15
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] after = new int[temperatures.length];
        int j;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            j = i + 1;
            while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    after[i] = j - i;
                    break;
                }
                if (after[j] > 0) {
                    j += after[j];
                } else break;
            }
        }
        return after;
    }

    /**
     * 单调栈 维护一个温度单调递减的单调栈
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        // 从左向右遍历
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            // 如果栈不为空, 将栈中小于当前温度的项目都弹出同时更新结果数组
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            // 将当前温度入栈
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
