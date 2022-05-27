package com.leetcode.main.interval901.q946;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-13
 * @see com.leetcode.offer.q31.Solution
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num); // num 入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
