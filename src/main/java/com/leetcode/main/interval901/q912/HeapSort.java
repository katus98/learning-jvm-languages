package com.leetcode.main.interval901.q912;

/**
 * 堆排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class HeapSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        int len = nums.length - 1;
        for (int i = len / 2; i >= 0; i--) {
            sort(nums, i, len);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            sort(nums, 0, i - 1);
        }
        return nums;
    }

    private void sort(int[] nums, int i, int len) {
        while ((i << 1) + 1 <= len) {
            int son1 = (i << 1) + 1;
            int son2 = (i << 1) + 2;
            int large;
            if (son1 <= len && nums[son1] > nums[i]) {
                large = son1;
            } else {
                large = i;
            }
            if (son2 <= len && nums[son2] > nums[large]) {
                large = son2;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
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

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = heapSort.sortArray(new int[]{7, 6, 4, 7, 9, 1});
        for (int i : array) {
            System.out.println(i);
        }
    }
}
