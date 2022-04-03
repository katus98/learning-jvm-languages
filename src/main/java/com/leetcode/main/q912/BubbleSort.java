package com.leetcode.main.q912;

/**
 * 冒泡排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    @Override
    public ListNode sortChainTable(ListNode head) {
        return null;
    }
}
