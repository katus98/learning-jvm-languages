package com.leetcode.main.interval101.q143;

/**
 * 重排链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-14
 */
public class Solution {
    /**
     * 二分链表, 反转后半部分, 交替合并
     */
    public void reorderList(ListNode head) {
        ListNode fast = head, dummyHead = new ListNode(-1, head), slow = dummyHead;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode list2 = slow.next;
        slow.next = null;
        list2 = reverse(list2);
        ListNode node1 = head, node2 = list2, before = dummyHead;
        while (node1 != null) {
            before.next = node1;
            node1 = node1.next;
            before = before.next;
            if (node2 != null) {
                before.next = node2;
                node2 = node2.next;
                before = before.next;
            }
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, nex;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
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
