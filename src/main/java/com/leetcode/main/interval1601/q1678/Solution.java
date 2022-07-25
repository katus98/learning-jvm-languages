package com.leetcode.main.interval1601.q1678;

/**
 * 设计 Goal 解析器
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-24
 */
public class Solution {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
