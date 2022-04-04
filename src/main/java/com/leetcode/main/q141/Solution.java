package com.leetcode.main.q141;

/**
 * 环形链表
 * 快慢指针, 一个走一步, 一个走两步, 如果相等则有环, 如果有null则无环
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-04
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode c1 = head, c2 = head;
        while (c1 != null && c2 != null) {
            c1 = c1.next;
            c2 = c2.next;
            if (c2 != null) {
                c2 = c2.next;
            } else {
                break;
            }
            if (c1 == c2) return true;
        }
        return false;
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
