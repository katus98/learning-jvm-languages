package com.leetcode.main.q93;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-28
 */
public class Solution {
    private final List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        list.clear();
        dfs(new StringBuilder(), 0, 4, s);
        return list;
    }

    private void dfs(StringBuilder builder, int idx, int count, String s) {
        if (idx >= s.length()) return;
        for (int i = 1; i <= 3; i++) {
            int nexIdx = idx + i;
            if (nexIdx > s.length()) break;
            String theStr = s.substring(idx, nexIdx);
            if ((theStr.charAt(0) != '0' || i == 1) && Integer.parseInt(theStr) <= 255) {
                builder.append(theStr);
                if (count > 1) {
                    builder.append('.');
                    dfs(builder, nexIdx, count - 1, s);
                    builder.delete(builder.length() - theStr.length() - 1, builder.length());
                } else {
                    if (nexIdx == s.length()) {
                        list.add(builder.toString());
                    }
                    builder.delete(builder.length() - theStr.length(), builder.length());
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.restoreIpAddresses("25525511135").forEach(System.out::println);
    }
}
