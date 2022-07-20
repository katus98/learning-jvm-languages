package com.leetcode.main.interval1801.q1822;

/**
 * 数组元素积的符号
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-20
 */
public class Solution {
    /**
     * 循环
     */
    public int arraySign(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) count++;
        }
        return count % 2 == 0 ? 1 : -1;
    }
}
