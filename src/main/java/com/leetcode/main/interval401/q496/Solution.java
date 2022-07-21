package com.leetcode.main.interval401.q496;

/**
 * 下一个更大元素 I
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-21
 */
public class Solution {
    /**
     * 循环
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = getNext(nums1[i], nums2);
        }
        return res;
    }

    private int getNext(int num, int[] array) {
        int i = 0;
        while (array[i] != num) i++;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] > num) return array[j];
        }
        return -1;
    }
}
