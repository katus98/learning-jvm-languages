package com.leetcode.offer.q44;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 */
public class Solution {
    public int findNthDigit(int n) {
        if (n == 0) return 0;
        long dNum = 0, bound = 0, index, lastBound = bound, numBound = 1, lastNumBound = 1;
        while (n > bound) {
            lastNumBound = numBound;
            lastBound = bound;
            numBound += 9 * power(10, dNum);
            bound += (9 * power(10, dNum)) * (dNum + 1);
            dNum++;
        }
        index = n - lastBound - 1;
        long realIndex = index / dNum;
        long realNum = realIndex + lastNumBound;
        return (int) getDigit(realNum, dNum - index % dNum);
    }

    private long getDigit(long num, long i) {
        long digit = 0;
        for (int j = 0; j < i; j++) {
            digit = num % 10;
            num /= 10;
        }
        return digit;
    }

    private long power(long x, long n) {
        if (n == 0) return 1;
        long res = x;
        for (long i = 0; i < n - 1; i++) {
            res *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(1000000000));
    }
}
