package com.leetcode.main.interval1501.q1502;

import java.util.Arrays;

/**
 * 判断能否形成等差数列
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-20
 */
public class Solution {
    /**
     * 排序 + 循环
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int delta = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (delta != arr[i] - arr[i - 1]) return false;
        }
        return true;
    }
}
