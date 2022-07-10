package com.leetcode.competition.weekly.w301;

import java.util.Arrays;

/**
 * 装满杯子需要的最短总时长
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-10
 */
public class Solution6112 {
    public int fillCups(int[] amount) {
        int count = 0;
        Arrays.sort(amount);
        while (amount[2] > 0) {
            if (amount[1] > 0) {
                amount[1]--;
            }
            amount[2]--;
            count++;
            Arrays.sort(amount);
        }
        return count;
    }
}
