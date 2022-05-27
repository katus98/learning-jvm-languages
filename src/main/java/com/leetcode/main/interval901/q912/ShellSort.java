package com.leetcode.main.interval901.q912;

/**
 * 希尔排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class ShellSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        int temp;
        for (int step = nums.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                temp = nums[i];
                int j = i - step;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = temp;
            }
        }
        return nums;
    }

    @Override
    public ListNode sortChainTable(ListNode head) {
        return null;
    }
}
