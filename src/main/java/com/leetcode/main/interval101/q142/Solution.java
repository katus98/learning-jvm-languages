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
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
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
