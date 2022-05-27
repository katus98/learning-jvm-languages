package com.leetcode.main.q24;

/**
 * 两两交换链表中的节点
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-27
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head), frontHead = dummyHead;
        while (frontHead.next != null) {
            if (frontHead.next.next != null) {
                swapToNext(frontHead);
                frontHead = frontHead.next.next;
            } else {
                break;
            }
        }
        return dummyHead.next;
    }

    private void swapToNext(ListNode frontHead) {
        ListNode head = frontHead.next;
        ListNode nex = head.next;
        ListNode realNex = nex.next;
        frontHead.next = nex;
        nex.next = head;
        head.next = realNex;
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
