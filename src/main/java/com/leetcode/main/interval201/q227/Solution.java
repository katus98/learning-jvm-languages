package com.leetcode.main.interval201.q227;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-27
 */
public class Solution {
    public int calculate(String s) {
        // 借助栈来实现
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        // 记录上一个符号
        char preSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 十进制生成当前位置的数
            if (Character.isDigit(ch)) {
                num *= 10;
                num += ch - '0';
            }
            // 如果当前是符号位 或者是最后一位
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        // 乘除法直接和栈顶元素相乘除
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                // 记录下一个符号
                preSign = ch;
                // 清空操作数
                num = 0;
            }
        }
        int result = 0;
        // 把栈内元素全部排出累加
        for (Integer integer : stack) {
            result += integer;
        }
        return result;
    }
}
