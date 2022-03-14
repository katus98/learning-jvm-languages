package com.leetcode.main.q19;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {
    /**
     * 先向后走n步, 然后设置一个新的指针和之前的同步走, 直到先走的指针走到最后, 后走的指针就是倒数第n
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(-1, head), before = fakeHead, current = head;
        int i = 0;
        while (current != null) {
            if (i++ == n) {
                break;
            }
            current = current.next;
        }
        while (current != null) {
            before = before.next;
            current = current.next;
        }
        before.next = before.next.next;
        return fakeHead.next;
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
