package com.leetcode.main.interval401.q413;

/**
 * 等差数列划分
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class Solution {
    /**
     * 差分 + 计数
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int[] deltaArr = new int[nums.length - 1];
        for (int i = 0; i < deltaArr.length; i++) {
            deltaArr[i] = nums[i + 1] - nums[i];
        }
        int last = Integer.MAX_VALUE, count = 0, total = 0;
        for (int delta : deltaArr) {
            // 如果当前差值与前一项差值相等则开始计数
            if (delta == last) {
                count++;
            } else {
                count = 0;   // 不相等归零
            }
            // 每次计数都要叠加以保证不重复
            total += count;
            last = delta;
        }
        return total;
    }
}
