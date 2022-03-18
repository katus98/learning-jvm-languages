package com.leetcode.offer.q43;

/**
 * 输入一个整数 n, 求1～n这n个整数的十进制表示中1出现的次数
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 */
public class Solution {
    /**
     * 逐位统计 (原创, 我就是神!)
     */
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(13));
    }
}
