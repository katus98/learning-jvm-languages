package com.leetcode.main.interval201.q203;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 移除链表元素
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-26
 */
public class Solution {

    /**
     * 思路: 将不需要删除的节点挪动到新的链表上
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(), end = dummyHead;
        while (head != null) {
            if (head.val != val) {
                end.next = head;
                end = end.next;
            }
            head = head.next;
        }
        end.next = null;
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
