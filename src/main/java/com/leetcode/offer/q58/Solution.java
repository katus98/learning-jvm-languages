package com.leetcode.offer.q58;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-20
 */
public class Solution {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]).append(" ");
        }
        return builder.toString().trim();
    }

    /**
     * 双指针, 实际上感觉没什么
     */
    public String reverseWords2(String s) {
        s = s.trim();    // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;    // 搜索首个空格
            res.append(s, i + 1, j + 1).append(" ");    // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--;    // 跳过单词间空格
            j = i;    // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}
