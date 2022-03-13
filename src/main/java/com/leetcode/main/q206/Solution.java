package com.leetcode.main.q206;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 * @see com.leetcode.offer.q23.Solution
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

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
