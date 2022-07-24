package com.leetcode.competition.weekly.w303;

import java.util.HashSet;
import java.util.Set;

/**
 * 第一个出现两次的字母
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-24
 */
public class Solution6124 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                return ch;
            } else {
                set.add(ch);
            }
        }
        return ' ';
    }
}
