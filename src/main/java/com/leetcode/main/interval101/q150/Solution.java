package com.leetcode.main.interval101.q150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-24
 */
public class Solution {
    /**
     * 栈
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                char sign = token.charAt(0);
                int b = stack.poll();
                int a = stack.poll();
                int res;
                switch (sign) {
                    case '+':
                        res = a + b;
                        break;
                    case '-':
                        res = a - b;
                        break;
                    case '*':
                        res = a * b;
                        break;
                    default:
                        res = a / b;
                }
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.poll();
    }
}
