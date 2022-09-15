package com.leetcode.main.interval201.q237;

/**
 * 删除链表中的节点
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-15
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        while (cur.next != null) {
            cur.val = cur.next.val;
            if (cur.next.next == null) break;
            cur = cur.next;
        }
        cur.next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
