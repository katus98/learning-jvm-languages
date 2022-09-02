package com.leetcode.exam.autumn.formal.oppo;

import java.util.Arrays;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-02
 */
public class Task1 {
    public int maxDigit(int[] digits) {
        Arrays.sort(digits);
        StringBuilder builder = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            builder.append(digits[i]);
        }
        return Integer.parseInt(builder.toString());
    }
}
