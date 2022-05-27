package com.leetcode.main.interval101.q142;

/**
 * 环形链表 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-17
 */
public class Solution {
    /**
     * 数学推导
     * 当快慢指针相遇之后, 从相遇点和链表头同时同速向后遍历, 必然会在入环点相遇
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head, ptr = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                while (slow != ptr) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
