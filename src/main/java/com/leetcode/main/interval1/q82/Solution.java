package com.leetcode.main.interval1.q82;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-16
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-101, null), before = dummyHead, current = head;
        boolean flag;
        while (current != null) {
            flag = false;
            // 获得重复序列的最后一个元素
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                flag = true;
            }
            if (flag) {
                // 如果重复了直接下一个
                current = current.next;
            } else {
                // 如果没重复添加到队尾
                before.next = current;
                before = before.next;
                current = current.next;
                // 队尾截断
                before.next = null;
            }
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
