package com.leetcode.main.interval1.q66;

/**
 * 加一
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-29
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }
        return digits;
    }
}
