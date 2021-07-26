package com.leetcode.q203;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 给你一个链表的头节点 head 和一个整数 val, 请你删除链表中所有满足 Node.val == val 的节点, 并返回 新的头节点
 *
 * 链接: https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-26
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;
        prev.next = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }
            prev = prev.next;
        }
        return dummyHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head != null) {
            if (head.val == val) {
                head = head.next;
            }
            head.next = removeElements2(head.next, val);
        }
        return head;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
