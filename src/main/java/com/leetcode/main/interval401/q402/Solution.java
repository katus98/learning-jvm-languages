package com.leetcode.main.interval401.q402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移掉K位数字
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-29
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        // 使用双向队列
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            // 如果上一个元素和当前元素之间是递减的则删除上一个元素
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > ch) {
                deque.pollLast();
                k--;
            }
            // 添加当前元素
            deque.offerLast(ch);
        }
        // 从非递减序列中删除最后面的元素
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder builder = new StringBuilder();
        // 从前面一个个排出元素拼成字符串
        while (!deque.isEmpty()) {
            char ch = deque.pollFirst();
            // 去除前导0
            if (builder.length() != 0 || ch != '0') {
                builder.append(ch);
            }
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
