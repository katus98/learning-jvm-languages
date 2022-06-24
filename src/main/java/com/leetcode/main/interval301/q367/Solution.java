package com.leetcode.main.interval301.q367;

/**
 * 有效的完全平方数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class Solution {
    /**
     * 最基本的二分查找
     */
    public boolean isPerfectSquare(int num) {
        int start = 1, end = Math.min(46340, num), cur;
        while (start < end) {
            cur = start + ((end - start) >> 1);
            if (cur * cur > num) {
                end = cur;
            } else if (cur * cur < num) {
                start = cur + 1;
            } else {
                start = cur;
                end = cur;
            }
        }
        return start * start == num;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }
}
