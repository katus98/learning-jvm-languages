package com.leetcode.main.q136;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-19
 * @see com.leetcode.offer.q56.Solution
 */
public class Solution {
    /**
     * 0与任何数值异或都为任何值
     * 两个相等的数值异或等于0
     * 全部异或之后剩下的数值就是不重复的那个数
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
