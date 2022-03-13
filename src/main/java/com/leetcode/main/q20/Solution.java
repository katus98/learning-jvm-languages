package com.leetcode.main.q20;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 给定一个只包括 '(', ')', '{', '}', '[', ']'的字符串 s, 判断字符串是否有效.
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合,
 * 左括号必须以正确的顺序闭合.
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-23
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (aChar) {
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    void test() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
