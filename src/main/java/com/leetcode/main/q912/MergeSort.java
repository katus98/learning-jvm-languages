package com.leetcode.main.q912;

/**
 * 归并排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-03
 */
public class MergeSort implements Sort {
    @Override
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    private void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;   // 开始递归划分
            sort(nums, left, mid, temp);   // 归并排序左部分(left, mid)
            sort(nums, mid + 1, right, temp);  // 归并排序右部分(mid+1, right)
            merge(nums, left, mid, right, temp);  // 合并
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;   // 左部分首元素
        int j = mid + 1;   // 右部分首元素
        int t = i;
        while (i <= mid && j <= right) {   // 在两者范围之内
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {   // 右边遍历完事了   左边还剩呢
            temp[t++] = nums[i++];
        }
        while (j <= right) {   // 左边遍历完事了   右边还剩了
            temp[t++] = nums[j++];
        }
        // 将排序好的序列复制回去
        System.arraycopy(temp, left, nums, left, right + 1 - left);
    }

    @Override
    public ListNode sortChainTable(ListNode head) {
        return null;
    }
}
