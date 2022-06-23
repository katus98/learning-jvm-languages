package com.leetcode.main.interval801.q852;

/**
 * 山脉数组的峰顶索引
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-23
 */
public class Solution {
    /**
     * 最基本的二分查找
     */
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1, end = arr.length - 2, cur;
        while (start < end) {
            cur = start + ((end - start) >> 1);
            if (arr[cur - 1] < arr[cur] && arr[cur] < arr[cur + 1]) {
                start = cur + 1;
            } else if (arr[cur - 1] > arr[cur] && arr[cur] > arr[cur + 1]) {
                end = cur;
            } else {
                start = cur;
                end = cur;
            }
        }
        return start;
    }
}
