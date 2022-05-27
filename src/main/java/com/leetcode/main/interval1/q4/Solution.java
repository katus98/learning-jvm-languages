package com.leetcode.main.interval1.q4;

/**
 * 寻找两个正序数组的中位数
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {
    /**
     * 我们分别找第 (m+n+1) / 2 个, 和 (m+n+2) / 2 个, 然后求其平均值即可, 这对奇偶数均适用
     * 这里的第几个是从1开始计算的
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 找到两个有序数组中第k小的数字
     *
     * @param nums1 数组1
     * @param i     nums1的起始位置
     * @param nums2 数组2
     * @param j     nums2的起始位置
     * @param k     找到第 k 小的元素
     * @return 第 k 小的元素
     */
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 当nums1为空数组时, 直接在nums2中向后找k个位置即可
        if (i >= nums1.length) return nums2[j + k - 1];
        // 当nums2为空数组时, 直接在nums1中向后找k个位置即可
        if (j >= nums2.length) return nums1[i + k - 1];
        // 如果k为1, 则直接返回两个数组头较小的那个即可
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        // 两个数组分别向后找 k / 2 个位置的数字
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        // 判断大小, 小的一边的跳过的 k / 2 部分不可能会有第k小的元素, 所以可以排除
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
