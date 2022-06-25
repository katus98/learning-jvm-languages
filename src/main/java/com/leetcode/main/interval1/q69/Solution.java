package com.leetcode.main.interval1.q69;

/**
 * x 的平方根
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-24
 */
public class Solution {
    /**
     * 另一种二分法范式
     * 不是寻找target而是寻找比target大或者小一点的元素
     * 借助一个额外的变量存储结果, 循环条件start <= end, 分支都需要变化区间+-1
     */
    public int mySqrt(int x) {
        int start = 0, end = x, ans = -1;
        while (start <= end) {
            int cur = start + ((end - start) >> 1);
            if ((long) cur * cur <= x) {
                ans = cur;
                start = cur + 1;
            } else {
                end = cur - 1;
            }
        }
        return ans;
    }
}
