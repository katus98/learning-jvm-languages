package com.leetcode.main.interval201.q224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-05
 */
public class Solution {
    /**
     * 因为只有加减运算, 直接将运算加到结果上, 用sign变量标识当前数字最终的符号
     */
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        // 初始正
        stack.push(1);
        int sign = 1;
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            switch (ch) {
                case ' ':   // 空字符直接忽略
                    i++;
                    break;
                case '+':   // 加法不会改变栈顶符号
                    sign = stack.peek();
                    i++;
                    break;
                case '-':   // 减法会改变栈顶符号
                    sign = -stack.peek();
                    i++;
                    break;
                case '(':   // 左括号需要压入新的符号
                    stack.push(sign);
                    i++;
                    break;
                case ')':   // 右括号需要弹出栈顶符号
                    stack.pop();
                    i++;
                    break;
                default:
                    long num = 0;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    ret += sign * num;
            }
        }
        return ret;
    }
}
