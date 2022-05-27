package com.leetcode.main.interval1.q92;

/**
 * 反转链表 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-04
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = null, end = null, dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead, nex, current = head;
        while (current != null) {
            if (left > 1) {
                pre = pre.next;
            }
            if (left-- == 1) {
                start = current;
            }
            if (right-- == 1) {
                end = current;
                break;
            }
            current = current.next;
        }
        current = start;
        pre.next = end;
        pre = end.next;
        while (pre != end) {
            nex = current.next;
            current.next = pre;
            pre = current;
            current = nex;
        }
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
