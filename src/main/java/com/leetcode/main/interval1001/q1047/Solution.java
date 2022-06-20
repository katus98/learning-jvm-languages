package com.leetcode.main.interval1001.q1047;

/**
 * 删除字符串中的所有相邻重复项
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-20
 */
public class Solution {
    /**
     * 暴力超时
     */
    public String removeDuplicates(String s) {
        char[] chs = s.toCharArray();
        int i, j;
        boolean flag = true;
        while (flag) {
            flag = false;
            i = 0;
            while (i < chs.length) {
                while (i < chs.length && chs[i] == '-') {
                    i++;
                }
                j = i + 1;
                while (j < chs.length && chs[j] == '-') {
                    j++;
                }
                if (j < chs.length && chs[i] == chs[j]) {
                    chs[i] = '-';
                    chs[j] = '-';
                    flag = true;
                }
                i = j;
            }
        }
        return new String(chs).replace("-", "");
    }

    /**
     * 栈
     */
    public String removeDuplicates2(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (builder.length() > 0 && builder.charAt(builder.length() - 1) == ch) {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates2("abbaca"));
    }
}
