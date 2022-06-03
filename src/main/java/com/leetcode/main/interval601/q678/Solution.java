package com.leetcode.main.interval601.q678;

/**
 * 有效的括号字符串
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-03
 */
public class Solution {
    public boolean checkValidString(String s) {
        // 记录未匹配的左括号个数范围
        int lower = 0, upper = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    // 如果是左括号, 上下界+1
                    upper++;
                    lower++;
                    break;
                case '*':
                    // 如果是*, 上界+1(可能是左括号), 下界-1(可能是右括号)
                    upper++;
                    lower = Math.max(0, lower - 1);
                    break;
                case ')':
                    // 如果是), 上界-1, 下界-1, 如果上界触底则false
                    if (upper <= 0) return false;
                    if (lower > 0) lower--;
                    upper--;
                    break;
            }
        }
        return lower == 0;   // 尚未匹配的左括号个数最小为0
    }
}
