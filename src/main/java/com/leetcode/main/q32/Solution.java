package com.leetcode.main.q32;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-22
 */
public class Solution {
    /**
     * 通过栈来实现
     * 对于遇到的每个 ‘(’, 我们将它的下标放入栈中
     * 对于遇到的每个 ‘)’, 我们先弹出栈顶元素表示匹配了当前右括号.
     * * 如果栈为空, 说明当前的右括号为没有被匹配的右括号, 我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     * * 如果栈不为空, 当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     */
    public int longestValidParentheses(String s) {
        int maxSize = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 说明当前的右括号没有匹配的左括号, 压入当前右括号作为新的栈底
                    stack.push(i);
                } else {
                    // 说明当前右括号有匹配, 直接减去没匹配的栈顶即可
                    if (i - stack.peek() > maxSize) {
                        maxSize = i - stack.peek();
                    }
                }
            }
        }
        return maxSize;
    }

    /**
     * DP
     * s[i]=‘)’ 且 s[i−1]=‘(’: dp[i]=dp[i−2]+2
     * s[i]=‘)’ 且 s[i−1]=‘)’ 且 s[i−dp[i−1]−1]=‘(’: dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     */
    public int longestValidParentheses2(String s) {
        int maxSize = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                dp[i] = 0;
            } else {
                if (i > 0) {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = getDp(dp, i - 2) + 2;
                    } else {
                        if (i - getDp(dp, i - 1) - 1 >= 0 && i - getDp(dp, i - 1) - 1 < dp.length) {
                            if (s.charAt(i - getDp(dp, i - 1) - 1) == '(') {
                                dp[i] = getDp(dp, i - 1) + getDp(dp, i - 2 - getDp(dp, i - 1)) + 2;
                            } else {
                                dp[i] = 0;
                            }
                        }
                    }
                }
            }
        }
        for (int j : dp) {
            if (maxSize < j) {
                maxSize = j;
            }
        }
        return maxSize;
    }

    private int getDp(int[] dp, int n) {
        return n >= 0 && n < dp.length ? dp[n] : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()()("));
    }
}
