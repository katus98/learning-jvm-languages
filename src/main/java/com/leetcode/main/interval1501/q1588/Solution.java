package com.leetcode.main.interval1501.q1588;

/**
 * 所有奇数长度子数组的和
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-22
 */
public class Solution {
    /**
     * 迭代计算
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int c1 = Math.min(i + 1, arr.length - i);
            for (int j = 1; j <= arr.length; j += 2) {
                int c2 = arr.length - j + 1;
                sum += Math.min(j, Math.min(c1, c2)) * arr[i];
            }
        }
        return sum;
    }
}
