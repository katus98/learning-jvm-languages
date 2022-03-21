package com.leetcode.offer.q56;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-20
 */
public class Solution2 {
    private final int[] digits = new int[32];
    /**
     * 位运算, 将所有数的每一位加起来然后对3取余, 剩下的拼回去就是单独的数
     * 这是一个通用的方法
     */
    public int singleNumber(int[] nums) {
        for (int num : nums) {
            int i = 0;
            while (i < 32) {
                digits[i] += num & 1;
                num >>= 1;
                i++;
            }
        }
        int res = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] % 3;
            res <<= 1;
            res += digits[i];
        }
        return res;
    }
}
