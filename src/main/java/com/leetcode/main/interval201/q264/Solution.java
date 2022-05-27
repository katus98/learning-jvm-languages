package com.leetcode.main.interval201.q264;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-18
 * @see com.leetcode.offer.q49.Solution
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] array = new int[n];
        array[0] = 1;
        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 1; i < n; i++) {
            array[i] = Math.min(Math.min(2 * array[n1], 3 * array[n2]), 5 * array[n3]);
            if (2 * array[n1] == array[i]) {
                n1++;
            }
            if (3 * array[n2] == array[i]) {
                n2++;
            }
            if (5 * array[n3] == array[i]) {
                n3++;
            }
        }
        return array[n - 1];
    }
}
