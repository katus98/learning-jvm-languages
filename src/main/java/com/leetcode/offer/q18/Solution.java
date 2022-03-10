package com.leetcode.offer.q18;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-10
 */
public class Solution {
    /**
     * 原创, 虚拟头节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode fakeFirst = new ListNode(-1), before = fakeFirst;
        before.next = head;
        while (before.next != null) {
            if (before.next.val == val) {
                before.next = before.next.next;
                break;
            }
            before = before.next;
        }
        return fakeFirst.next;
    }

    /**
     * 双指针, 感觉一般, 因为需要讨论特例
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode before = head, after = head.next;
        while (after != null) {
            if (after.val == val) {
                before.next = after.next;
                break;
            }
            before = before.next;
            after = after.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
