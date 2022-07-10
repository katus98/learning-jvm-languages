package com.leetcode.main.interval1.q83;

/**
 * 删除排序链表中的重复元素
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-29
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head, nex;
        while (cur != null) {
            nex = cur.next;
            while (nex != null && cur.val == nex.val) {
                nex = nex.next;
            }
            cur.next = nex;
            cur = nex;
        }
        return head;
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
