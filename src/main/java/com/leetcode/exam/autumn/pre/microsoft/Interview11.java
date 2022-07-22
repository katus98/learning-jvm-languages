package com.leetcode.exam.autumn.pre.microsoft;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-22
 */
public class Interview11 {
    private int getAllSmall(int[] array, int target) {
        if (array.length == 0) return -1;
        if (target < array[0]) return -1;
        if (target >= array[array.length - 1]) return array[array.length - 1];
        int start = 0, end = array.length - 1, cur;
        while (start < end) {
            cur = start + ((end - start + 1) >> 1);
            if (array[cur] < target) {
                start = cur;
            } else if (array[cur] > target) {
                end = cur - 1;
            } else {
                start = cur;
                end = cur;
            }
        }
        return array[start];
    }

    public static void main(String[] args) {
        Interview11 interview11 = new Interview11();
        System.out.println(interview11.getAllSmall(new int[]{4, 5, 9, 13, 24}, 7));
        System.out.println(interview11.getAllSmall(new int[]{4, 5, 7, 13, 24}, 7));
        System.out.println(interview11.getAllSmall(new int[]{4, 5, 8, 13, 24}, 7));
        System.out.println(interview11.getAllSmall(new int[]{3, 4, 5}, 7));
        System.out.println(interview11.getAllSmall(new int[]{55}, 7));
        System.out.println(interview11.getAllSmall(new int[]{}, 8));
    }
}
