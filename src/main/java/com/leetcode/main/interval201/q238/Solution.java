package com.leetcode.main.interval201.q238;

/**
 * 除自身以外数组的乘积
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-04
 */
public class Solution {
    /**
     * 前后缀乘积
     * 另外可以使用结果数组先存放前缀乘积, 然后再计算后缀乘积过程中逐步更新为结果可以节省空间
     */
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length], postfix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        res[0] = postfix[1];
        res[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = prefix[i - 1] * postfix[i + 1];
        }
        return res;
    }
}
