package com.leetcode.offer.q17;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 */
public class Solution {

    public int[] printNumbers(int n) {
        int upper = 0;
        for (int i = 0; i < n; i++) {
            upper *= 10;
            upper += 9;
        }
        int[] array = new int[upper];
        for (int i = 0; i < upper; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}
