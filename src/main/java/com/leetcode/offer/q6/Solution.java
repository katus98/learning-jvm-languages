package com.leetcode.offer.q6;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-06
 */
public class Solution {

    /**
     * 通过压入堆栈再排出来实现倒叙打印
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        int[] array = new int[stack.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    /**
     * 两次遍历链表, 第一次确定有几个元素, 第二次倒序放入数组
     */
    public int[] reversePrint2(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        int[] array = new int[size];
        current = head;
        for (int i = size - 1; i >= 0; i--) {
            array[i] = current.val;
            current = current.next;
        }
        return array;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
