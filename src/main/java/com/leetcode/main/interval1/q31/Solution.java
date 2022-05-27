package com.leetcode.main.interval1.q31;

/**
 * 下一个排列
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-21
 */
public class Solution {
    /**
     * 首先从后向前查找第一个顺序对 (i,i+1), 满足 a[i] < a[i+1]. 这样「较小数」即为 a[i]. 此时 [i+1,n) 必然是下降序列.
     * 如果找到了顺序对, 那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i] < a[j]. 这样「较大数」即为 a[j].
     * 交换 a[i] 与 a[j], 此时可以证明区间 [i+1,n) 必为降序. 我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序, 而无需对该区间进行排序.
     */
    public void nextPermutation(int[] nums) {
        int index, index2;
        for (index = nums.length - 2; index >= 0; index--) {
            if (nums[index] < nums[index + 1]) break;
        }
        if (index >= 0) {
            for (index2 = nums.length - 1; index2 > index; index2--) {
                if (nums[index2] > nums[index]) break;
            }
            swap(nums, index, index2);
        }
        reverse(nums, index + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
