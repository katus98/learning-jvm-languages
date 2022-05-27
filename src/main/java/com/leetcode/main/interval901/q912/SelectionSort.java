package com.leetcode.main.interval901.q912;

/**
 * 选择排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class SelectionSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        int minIndex, temp;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) minIndex = j;
            }
            if (minIndex != i) {
                temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        return nums;
    }

    @Override
    public ListNode sortChainTable(ListNode head) {
        return null;
    }
}
