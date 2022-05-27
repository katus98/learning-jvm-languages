package com.leetcode.main.interval101.q143;

/**
 * 重排链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-14
 */
public class Solution {
    public void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head), current = head, secondHead;
        // 统计链表长度
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        // 计算分界点
        int size = count;
        int first = size - size / 2;
        // 将前后链表拆分
        count = 0;
        current = dummyHead;
        while (count++ != first) {
            current = current.next;
        }
        secondHead = current.next;
        current.next = null;
        // 将后面的链表反转
        current = secondHead;
        ListNode pre = null, nex;
        while (current != null) {
            nex = current.next;
            current.next = pre;
            pre = current;
            current = nex;
        }
        secondHead = pre;
        // 两个链表交替合并成新链表
        current = dummyHead;
        ListNode current1 = head, current2 = secondHead;
        while (current1 != null) {
            current.next = current1;
            current1 = current1.next;
            current = current.next;
            if (current2 != null) {
                current.next = current2;
                current2 = current2.next;
                current = current.next;
            }
        }
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
