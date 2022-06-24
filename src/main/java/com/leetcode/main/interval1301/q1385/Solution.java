package com.leetcode.main.interval1301.q1385;

import java.util.Arrays;

/**
 * 两个数组间的距离值
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class Solution {
    /**
     * 情境下的二分查找
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int a : arr1) {
            // 在arr2中找到最接近a的元素与a的差值绝对值
            if (findMinDis(a, arr2) > d) {
                count++;
            }
        }
        return count;
    }

    private int findMinDis(int a, int[] arr) {
        // 二分法查找a在arr2中的位置
        int index = binarySearch(arr, a);
        // 比较位置和前后一个位置的最小差值绝对值返回
        int res = Math.abs(a - arr[index]);
        if (index + 1 < arr.length) {
            res = Math.min(res, Math.abs(a - arr[index + 1]));
        }
        if (index - 1 >= 0) {
            res = Math.min(res, Math.abs(a - arr[index - 1]));
        }
        return res;
    }

    private int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1, cur;
        while (start < end) {
            cur = start + ((end - start) >> 1);
            if (arr[cur] > target) {
                end = cur;
            } else if (arr[cur] < target) {
                start = cur + 1;
            } else {
                start = cur;
                end = cur;
            }
        }
        return start;
    }
}
