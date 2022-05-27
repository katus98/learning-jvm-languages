package com.leetcode.main.interval1.q22;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-24
 */
public class Solution {
    /**
     * 回溯法
     */
    private final List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        list.clear();
        generate(new StringBuilder(), n, n);
        return list;
    }

    private void generate(StringBuilder builder, int m, int n) {
        if (m > 0 || n > 0) {
            // 如果左括号没填完, 可以填入
            if (m > 0) {
                builder.append('(');
                generate(builder, m - 1, n);
                builder.deleteCharAt(builder.length() - 1);
            }
            // 只有当剩余的右括号多余左括号时才可以填入
            if (n > m) {
                builder.append(')');
                generate(builder, m, n - 1);
                builder.deleteCharAt(builder.length() - 1);
            }
        } else {
            list.add(builder.toString());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
