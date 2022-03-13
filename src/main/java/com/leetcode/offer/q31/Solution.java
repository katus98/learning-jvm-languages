package com.leetcode.offer.q31;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-13
 */
public class Solution {

    /**
     * 借用一个堆栈来模拟实际情况 (原创, 略嫌麻烦, 因为用了单层循环实现了实际上的双层循环)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, j = 0, n = pushed.length;
        while (i < n || j < n) {
            if (i < n && (stack.isEmpty() || popped[j] != stack.peek())) {
                stack.push(pushed[i++]);
                continue;
            }
            if (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
                continue;
            }
            break;
        }
        return !stack.isEmpty();
    }

    /**
     * 精简, 用双层循环来实现
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
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
