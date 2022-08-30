package com.leetcode.exam.autumn.formal.mt;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-29
 */
public class Interview2 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxSize = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isValid(s, i, j)) {
                    maxSize = Math.max(j - i + 1, maxSize);
                }
            }
        }
        return maxSize;
    }

    private boolean isValid(String s, int i, int j) {
        int leftCount = 0;
        for (int k = i; k <= j; k++) {
            char ch = s.charAt(k);
            if (ch == '(') {
                leftCount++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    return false;
                }
            }
        }
        return leftCount == 0;
    }

    public static void main(String[] args) {
        Interview2 interview2 = new Interview2();
        System.out.println(interview2.longestValidParentheses("(()"));
        System.out.println(interview2.longestValidParentheses("(())((()"));
    }
}
