package com.leetcode.main.interval1501.q1523;

/**
 * 在区间范围内统计奇数数目
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-17
 */
public class Solution {
    /**
     * 数学计算
     */
    public int countOdds(int low, int high) {
        int count = high - low + 1;
        int countOdd;
        if (count % 2 == 0) {
            countOdd = count / 2;
        } else {
            if (low % 2 == 1) {
                countOdd = count / 2 + 1;
            } else {
                countOdd = count / 2;
            }
        }
        return countOdd;
    }
}
