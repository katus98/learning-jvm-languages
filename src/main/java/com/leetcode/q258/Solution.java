package com.leetcode.q258;

/**
 * https://leetcode-cn.com/problems/add-digits/
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {

    public int addDigits(int num) {
        do {
            num = calDigits(num);
        } while (num >= 10);
        return num;
    }

    private int calDigits(int num) {
        int result = 0;
        do {
            result += num % 10;
            num = num / 10;
        } while (num != 0);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits(38));
        System.out.println(solution.addDigits(0));
    }
}
