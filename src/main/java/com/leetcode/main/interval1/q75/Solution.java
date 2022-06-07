package com.leetcode.main.interval1.q75;

/**
 * 颜色分类
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-07
 */
public class Solution {
    /**
     * 单指针, 先把0放在前面, 再把1放在0的后面
     */
    public void sortColors(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        j = i;
        while (j < nums.length) {
            if (nums[j] == 1) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    /**
     * 双指针
     */
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                ++p1;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                ++p0;
                ++p1;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
