package com.leetcode.main.interval1.q93;

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

    private void dfs2(StringBuilder builder, int idx, int count, String s) {
        if (idx >= s.length()) return;
        if (count == 1) {
            String str = s.substring(idx);
            if (isValid(str)) {
                builder.append(str);
                list.add(builder.toString());
                builder.delete(builder.length() - str.length(), builder.length());
            }
            return;
        }
        for (int len = 1; len <= 3; len++) {
            if (idx + len > s.length()) return;
            String str = s.substring(idx, idx + len);
            if (isValid(str)) {
                builder.append(str).append(".");
                dfs2(builder, idx + len, count - 1, s);
                builder.delete(builder.length() - str.length() - 1, builder.length());
            }
        }
    }

    private boolean isValid(String s) {
        if (s.isEmpty() || s.length() > 3) return false;
        if (s.length() == 1) return true;
        if (s.charAt(0) == '0') return false;
        return Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.restoreIpAddresses("25525511135").forEach(System.out::println);
    }
}
