package com.leetcode.main.interval901.q912;

import java.util.Random;

/**
 * 快速排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class QuickSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {
        if (end > start) {
            int x = new Random().nextInt(end - start + 1) + start;
            int pivot = nums[x], i = start;
            swap(nums, x, end);
            for (int j = start; j < end; j++) {
                if (nums[j] < pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, end);
            sort(nums, start, i - 1);
            sort(nums, i + 1, end);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Override
    public ListNode sortChainTable(ListNode head) {
        return null;
    }
}
