package com.leetcode.main.q912;

/**
 * 直接插入排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class InsertionSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        int num;
        for (int i = 1; i < nums.length; i++) {
            // 记录要插入的数据
            num = nums[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && num < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                nums[j] = num;
            }
        }
        return nums;
    }

    @Override
    public ListNode sortChainTable(ListNode head) {
        return null;
    }
}
