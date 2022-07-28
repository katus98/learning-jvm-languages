package com.leetcode.main.interval501.q524;

import java.util.Arrays;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-26
 */
public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            int c = -Integer.compare(o1.length(), o2.length());
            return c == 0 ? o1.compareTo(o2) : c;
        });
        for (String word : dictionary) {
            int i = 0, j = 0;
            while (i < word.length() && j < s.length()) {
                if (word.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i == word.length()) return word;
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}
