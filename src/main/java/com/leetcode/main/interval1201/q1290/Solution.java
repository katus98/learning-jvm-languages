package com.leetcode.main.interval1201.q1290;

/**
 * 二进制链表转整数
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-26
 */
public class Solution {
    /**
     * 遍历链表
     */
    public int getDecimalValue(ListNode head) {
        int res = 0;
        ListNode cur = head;
        while (cur != null) {
            res <<= 1;
            res += cur.val;
            cur = cur.next;
        }
        return res;
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
