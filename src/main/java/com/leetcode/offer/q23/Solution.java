package com.leetcode.offer.q23;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode current = head, old, newHead = null;
        while (current != null) {
            old = current.next;
            current.next = newHead;
            newHead = current;
            current = old;
        }
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
