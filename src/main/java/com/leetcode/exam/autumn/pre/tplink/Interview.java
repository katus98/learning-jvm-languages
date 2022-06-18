package com.leetcode.exam.autumn.pre.tplink;

import java.util.Arrays;

/**
 * @author SUN Katus
 * @version 1.0, 2022-06-17
 */
public class Interview {
    public int maxRage(int n, int[] arr) {
        Arrays.sort(arr);
        if (arr.length <= n) return 100;
        int maxRange = 0, start, end;
        for (int i = n - 1; i < arr.length; i++) {
            end = i + 1 < arr.length ? arr[i + 1] : 100;
            start = i - n < 0 ? -1 : arr[i - n];
            maxRange = Math.max(maxRange, end - start - 1);
        }
        return maxRange;
    }

    public static void main(String[] args) {
        Interview interview = new Interview();
        System.out.println(interview.maxRage(10, new int[]{1, 5, 7}));
        System.out.println(interview.maxRage(3, new int[]{1, 5, 7, 50, 30, 74}));
    }
}
