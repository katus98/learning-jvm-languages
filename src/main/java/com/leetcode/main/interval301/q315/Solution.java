package com.leetcode.main.interval301.q315;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-15
 */
public class Solution {
    private int[] index;   // 原数组中第i个元素所在的索引号
    private int[] temp;   // 临时排序数组
    private int[] tempIndex;   // 临时索引号数组
    private int[] ans;   // 结果数组

    public List<Integer> countSmaller(int[] nums) {
        this.index = new int[nums.length];
        this.temp = new int[nums.length];
        this.tempIndex = new int[nums.length];
        this.ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
        }
        int l = 0, r = nums.length - 1;
        mergeSort(nums, l, r);
        List<Integer> list = new ArrayList<>();
        for (int num : ans) {
            list.add(num);
        }
        return list;
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    public void merge(int[] a, int l, int mid, int r) {
        int i = l, j = mid + 1, cur = l;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                temp[cur] = a[i];
                tempIndex[cur] = index[i];
                // 左侧元素的贡献度等于右侧数组的指针偏移量
                ans[index[i]] += (j - mid - 1);
                ++i;
            } else {
                temp[cur] = a[j];
                tempIndex[cur] = index[j];
                ++j;
            }
            cur++;
        }
        while (i <= mid) {
            temp[cur] = a[i];
            tempIndex[cur] = index[i];
            ans[index[i]] += (j - mid - 1);
            ++i;
            ++cur;
        }
        while (j <= r) {
            temp[cur] = a[j];
            tempIndex[cur] = index[j];
            ++j;
            ++cur;
        }
        for (int k = l; k <= r; ++k) {
            // 新的索引数组更新
            index[k] = tempIndex[k];
            // 将排序好的数组放回原数组
            a[k] = temp[k];
        }
    }
}
