package com.leetcode.main.interval1.q70;

import com.leetcode.offer.q10.Solution2;

/**
 * 爬楼梯
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-08
 * @see Solution2
 */
public class Solution {

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        } else {
            int r1 = 1, r2 = 1, r3 = 0;
            for (int i = 2; i <= n; i++) {
                r3 = (r1 + r2);
                r1 = r2;
                r2 = r3;
            }
            return r3;
        }
    }
}
