package com.leetcode.main.q739;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
