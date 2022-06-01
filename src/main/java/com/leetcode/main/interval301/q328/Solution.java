package com.leetcode.main.interval301.q328;

/**
 * 奇偶链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-01
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyHead = new ListNode(-1, null), current = head, before = dummyHead;
        ListNode dummyHeadEven = new ListNode(-1, null), beforeEven = dummyHeadEven;
        while (current != null) {
            before.next = current;
            current = current.next;
            before = before.next;
            if (current != null) {
                beforeEven.next = current;
                current = current.next;
                beforeEven = beforeEven.next;
                beforeEven.next = null;
            }
        }
        before.next = dummyHeadEven.next;
        return dummyHead.next;
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
