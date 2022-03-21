package com.leetcode.offer.q57;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-20
 */
public class Solution {
    /**
     * 双指针从两端向中间靠拢
     * 本题原创了二分查找target, 排除了大于target的部分, 因为题目全是正数
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return null;
        int i = 0, j = nums.length - 1, sum = -1, c = i + ((j - i) >> 1);
        while (i < j) {
            if (nums[c] > target) {
                j = c;
            } else if (nums[c] < target) {
                i = c + 1;
            } else {
                i = c;
                j = c;
            }
            c = i + ((j - i) >> 1);
        }
        i = 0;
        j = c;
        while (i < j) {
            // 最好用target - num来比较防止溢出
            sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                break;
            }
        }
        if (sum == target) {
            return new int[]{nums[i], nums[j]};
        } else {
            return null;
        }
    }
}
