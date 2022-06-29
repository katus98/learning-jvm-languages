package com.leetcode.main.interval201.q201;

/**
 * 数字范围按位与
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-29
 */
public class Solution {
    /**
     * 原创非位运算的做法做位运算的事情
     * 公共前缀 + 0补位
     */
    public int rangeBitwiseAnd(int left, int right) {
        String strLeft = Integer.toBinaryString(left);
        String strRight = Integer.toBinaryString(right);
        StringBuilder builder = new StringBuilder();
        builder.append(strLeft);
        while (builder.length() < 32) {
            builder.insert(0, '0');
        }
        strLeft = builder.toString();
        builder.delete(0, builder.length());
        builder.append(strRight);
        while (builder.length() < 32) {
            builder.insert(0, '0');
        }
        strRight = builder.toString();
        builder.delete(0, builder.length());
        for (int i = 0; i < 32; i++) {
            char chL = strLeft.charAt(i);
            char chR = strRight.charAt(i);
            if (chL == chR) {
                builder.append(chL);
            } else {
                break;
            }
        }
        while (builder.length() < 32) {
            builder.append('0');
        }
        return Integer.parseInt(builder.toString(), 2);
    }

    /**
     * 两个边界数值同时右移直至相等再左移补0
     */
    public int rangeBitwiseAnd2(int left, int right) {
        int count = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }

    /**
     * 不断去除右边界最右侧的0直至小于左边界
     */
    public int rangeBitwiseAnd3(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(5, 7));
    }
}
