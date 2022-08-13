package com.leetcode.main.interval1201.q1249;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 移除无效的括号
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public class Solution {
    /**
     * 栈 + StringBuilder
     */
    public String minRemoveToMakeValid(String s) {
        Set<Integer> deleteSet = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    deleteSet.add(i);
                }
            }
        }
        deleteSet.addAll(stack);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!deleteSet.contains(i)) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
