package com.leetcode.main.interval1.q88;

/**
 * 合并两个有序数组
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-17
 */
public class Solution {
    /**
     * 逆序比较
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1, cur2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (cur1 >= 0 && cur2 >= 0) {
                nums1[i] = nums1[cur1] > nums2[cur2] ? nums1[cur1--] : nums2[cur2--];
            } else if (cur2 >= 0) {
                nums1[i] = nums2[cur2--];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 4, 6}, 3);
    }
}
