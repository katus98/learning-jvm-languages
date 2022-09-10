package com.leetcode.main.interval801.q860;

/**
 * 柠檬水找零
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-10
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] array = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                array[0]++;
            } else if (bill == 10) {
                if (array[0] > 0) {
                    array[0]--;
                    array[1]++;
                } else return false;
            } else {
                if (array[0] > 0 && array[1] > 0) {
                    array[0]--;
                    array[1]--;
                    array[2]++;
                } else if (array[0] >= 3) {
                    array[0] -= 3;
                    array[2]++;
                } else return false;
            }
        }
        return true;
    }
}
