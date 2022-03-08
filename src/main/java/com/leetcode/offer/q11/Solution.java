package com.leetcode.offer.q11;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-08
 */
public class Solution {

    /**
     * 反向遍历
     */
    public int minArray(int[] numbers) {
        int i;
        for (i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                break;
            }
        }
        return numbers[i];
    }

    /**
     * 二分查找
     */
    public int minArray2(int[] numbers) {
        int start = 0, end = numbers.length - 1, i;
        while (start < end) {
            i = start + (end - start) / 2;
            if (numbers[i] < numbers[end]) {
                end = i;
            } else if (numbers[i] > numbers[end]) {
                start = i + 1;
            } else {
                end = end - 1;
            }
        }
        return numbers[start];
    }
}
