package com.leetcode.main.interval801.q844;

/**
 * 比较含退格的字符串
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-14
 */
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = processStr(s);
        String s2 = processStr(t);
        return s1.equals(s2);
    }

    private String processStr(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '#' && builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            if (ch != '#') {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    /**
     * 双指针, 从右向左扫描
     */
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
