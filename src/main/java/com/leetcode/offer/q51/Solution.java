package com.leetcode.offer.q51;

/**
 * 数组中的逆序对
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-18
 */
public class Solution {

    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
        }
        return count;
    }

    private int count = 0;

    /**
     * 归并排序
     */
    public int reversePairs2(int[] nums) {
        this.count = 0;
        sort(nums, 0, nums.length - 1, new int[nums.length]);
        return count;
    }

    public void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;   //开始递归划分
            sort(nums, left, mid, temp);   //归并排序左部分(left, mid)
            sort(nums, mid + 1, right, temp);  //归并排序右部分(mid+1, right)
            merge(nums, left, mid, right, temp);  //合并
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;   //左部分首元素
        int j = mid + 1;   //右部分首元素
        int t = 0;
        while (i <= mid && j <= right) {   //在范围之内
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                count += (mid - i + 1);   //只需要这行代码
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {   //右边遍历完事了   左边还剩呢
            temp[t++] = nums[i++];
        }
        while (j <= right) {   //左边遍历完事了   右边还剩了
            temp[t++] = nums[j++];
        }
        t = 0;   //将temp中的元素  全部都copy到原数组里边去
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }
}
