package com.leetcode.main.q82;

/**
 * 删除排序链表中的重复元素 II
 * 没什么特别的, 一次遍历, 注意有重复和无重复的时候链表连接时存在逻辑区别
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-16
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-101, head), before = dummyHead, current = head;
        boolean flag;
        while (current != null) {
            flag = false;
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                flag = true;
            }
            if (flag) {
                before.next = current.next;
            } else {
                before.next = current;
                before = before.next;
            }
            current = current.next;
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
