package com.leetcode.main.interval801.q876;

/**
 * 链表的中间结点
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-14
 */
public class Solution {
    /**
     * 快慢指针
     */
    public ListNode middleNode(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head), fast = dummyHead, slow = dummyHead;
        boolean flag = false;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                flag = true;
                break;
            }
            slow = slow.next;
        }
        return flag ? slow.next : slow;
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
