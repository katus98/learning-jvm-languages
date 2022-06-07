package com.leetcode.main.interval101.q179;

import java.util.Arrays;

/**
 * 最大数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-07
 */
public class Solution {
    /**
     * 自定义排序
     */
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            builder.append(arr[i]);
        }
        String res = builder.toString();
        int i = 0;
        for (i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') break;
        }
        return i == res.length() ? "0" : res.substring(i);
    }
}
