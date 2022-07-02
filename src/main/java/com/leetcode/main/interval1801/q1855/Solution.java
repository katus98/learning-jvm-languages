package com.leetcode.main.interval1801.q1855;

/**
 * 下标对中的最大距离
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-02
 */
public class Solution {
    /**
     * 双指针
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int j = 0, maxDis = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length && nums1[i] <= nums2[j]) j++;
            if (maxDis < j - i - 1) {
                maxDis = j - i - 1;
            }
            j = Math.max(i + 1, j - 1);
        }
        return maxDis;
    }
}
