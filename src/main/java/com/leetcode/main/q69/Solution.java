package com.leetcode.main.q69;

/**
 * x 的平方根
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-24
 */
public class Solution {
    /**
     * 二分法
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 注意强制类型转换
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
