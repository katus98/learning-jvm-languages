package com.leetcode.q856;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-23
 */
public class BalanceString {

    private int calScore(String s) {
        int score = 0, tempScore = 0;
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '(') {
                tempScore = 0;
                stack.push("" + aChar);
            } else {
                stack.pop();
                // todo
                if (stack.isEmpty()) {
                    score += tempScore * 2;
                } else {
                    tempScore += 1;
                }
            }
        }
        return score;
    }

    private int calScore2(String s) {
        int deep = 0, score = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                deep++;
            } else {
                deep--;
                if (chars[i - 1] == '(') {
                    score += (1 << deep);
                }
            }
        }
        return score;
    }

    @Test
    void test() {
        System.out.println(calScore2("()"));
        System.out.println(calScore2("(())"));
        System.out.println(calScore2("()()"));
        System.out.println(calScore2("(()(()))"));
    }
}
