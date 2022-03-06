package com.leetcode.offer.q3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-06
 */
public class Solution {

    /**
     * 遍历数组放入set直至set容量没有增加
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size() != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
