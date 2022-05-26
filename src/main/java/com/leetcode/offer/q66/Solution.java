package com.leetcode.offer.q66;

/**
 * @author SUN Katus
 * @version 1.0, 2022-05-26
 */
public class Solution {
    /**
     * DP: left左侧所有数的乘积, right右侧所有数的乘积
     */
    public int[] constructArr(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[] answer = new int[a.length];
        if (left.length > 0) {
            left[0] = 1;
        }
        if (right.length > 0) {
            right[right.length - 1] = 1;
        }
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }

    /**
     * 在方法一的基础上省下空间占用
     * 使用结果数组作为left, right不存储动态生成, 从后向前遍历
     */
    public int[] constructArr2(int[] a) {
        int[] answer = new int[a.length];
        int right = 1;
        if (answer.length > 0) {
            answer[0] = 1;
        }
        for (int i = 1; i < answer.length; i++) {
            answer[i] = answer[i - 1] * a[i - 1];
        }
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= a[i];
        }
        return answer;
    }
}
