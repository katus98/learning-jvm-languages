package com.leetcode.offer.q64;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-25
 */
public class Solution {
    public int sumNums(int n) {
        // 短路计算, 如果n > 0, 才会计算后面, 否则直接返回n = 0
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
