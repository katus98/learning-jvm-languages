package com.leetcode.main.q233;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 * @see com.leetcode.offer.q43.Solution
 */
public class Solution {

    public int countDigitOne(int n) {
        int x = n, y = 1, count = 0;
        while (x > 0) {
            if (x % 10 > 1) {
                count += (x / 10 + 1) * y;
            } else if (x % 10 == 1) {
                count += x / 10 * y + n % y + 1;
            } else {
                count += x / 10 * y;
            }
            x /= 10;
            y *= 10;
        }
        return count;
    }
}
