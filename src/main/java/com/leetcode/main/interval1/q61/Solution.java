package com.leetcode.main.interval1.q61;

/**
 * 旋转链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-01
 */
public class Solution {
    /**
     * 首先统计链表节点数量, 然后将右旋换算成左旋, 拼接一下
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1, head), current = head, before = dummyHead, last;
        int count = 0;
        while (current != null) {
            current = current.next;
            before = before.next;
            count++;
        }
        last = before;
        before = dummyHead;
        k = (count - (k % count)) % count;
        if (k == 0) return head;
        while (k-- > 0) {
            before = before.next;
        }
        ListNode newHead = before.next;
        before.next = null;
        last.next = head;
        dummyHead.next = newHead;
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
