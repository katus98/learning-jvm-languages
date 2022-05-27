package com.leetcode.main.interval301.q343;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-09
 * @see com.leetcode.offer.q14.Solution
 */
public class Solution {
    /**
     * 贪心或者数学推导
     */
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        else if (n == 4) return n;
        int b = n / 3, a = n % 3;
        switch (a) {
            case 0:
                return (int) Math.pow(3, b);
            case 1:
                return ((int) Math.pow(3, b - 1)) * 4;
            case 2:
                return ((int) Math.pow(3, b)) * 2;
        }
        return 1;
    }
}
