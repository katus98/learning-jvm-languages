package com.leetcode.main.interval1.q19;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {
    /**
     * 先向后走n步, 然后设置一个新的指针和之前的同步走, 直到先走的指针走到最后, 后走的指针就是倒数第n
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head), front = head, back = dummyHead;
        while (--n != 0) {
            front = front.next;
        }
        while (front.next != null) {
            back = back.next;
            front = front.next;
        }
        back.next = back.next.next;
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
