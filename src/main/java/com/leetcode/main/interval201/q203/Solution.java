package com.leetcode.main.interval201.q203;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 给你一个链表的头节点 head 和一个整数 val, 请你删除链表中所有满足 Node.val == val 的节点, 并返回 新的头节点
 * 链接: https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-26
 */
public class Solution {

    /**
     * 思路: 将不需要删除的节点挪动到新的链表上
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;
        while (head != null) {
            if (head.val != val) {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        prev.next = null;
        return dummyHead.next;
    }

    /**
     * 思路: 将链表视为首节点和子链表两个部分
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head != null) {
            if (head.val == val) {
                head = removeElements2(head.next, val);
            } else {
                head.next = removeElements2(head.next, val);
            }
        }
        return head;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;
    }
}
