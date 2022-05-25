package com.leetcode.offer.q65;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-25
 */
public class Solution {
    /**
     * 位运算
     */
    public int add(int a, int b) {
        // 每次计算的结果保存在a中
        while (b != 0) {   // 当进位为 0 时跳出
            int c = (a & b) << 1;   // c = 进位
            a ^= b;   // a = 非进位和
            b = c;   // b = 进位
            // 下一轮循环计算本次结果a和进位值b的和, 直至进位为0
        }
        return a;
    }
}
