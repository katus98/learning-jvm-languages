package com.leetcode.main.interval1.q58;

/**
 * 最后一个单词的长度
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-27
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] items = s.split("\\s+");
        return items[items.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        int count = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ' && flag) {
                break;
            } else if (ch != ' ') {
                flag = true;
                count++;
            }
        }
        return count;
    }
}
