package com.leetcode.main.interval1001.q1021;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 删除最外层的括号
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-28
 */
public class Solution {
    /**
     * 栈: 当栈为空时记录刚刚排出的元素和当前元素的索引号, 生成新的字符串的时候排除记录的这些位置的元素
     */
    public String removeOuterParentheses(String s) {
        Set<Integer> indexSet = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                Integer index = stack.pop();
                if (stack.isEmpty()) {
                    indexSet.add(index);
                    indexSet.add(i);
                }
            }
        }
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!indexSet.contains(i)) {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }
}
