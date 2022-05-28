package com.leetcode.main.interval1.q17;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-28
 */
public class Solution {
    private final List<String> list = new ArrayList<>();
    private final Map<Character, char[]> map = new HashMap<>();

    /**
     * 普通回溯
     * 注意空字符串的结果
     */
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        this.list.clear();
        this.map.clear();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        dfs(digits.toCharArray(), 0, new StringBuilder());
        return list;
    }

    private void dfs(char[] chs, int index, StringBuilder builder) {
        if (index >= chs.length) {
            list.add(builder.toString());
            return;
        }
        char[] chars = map.get(chs[index]);
        for (char ch : chars) {
            builder.append(ch);
            dfs(chs, index + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
