package com.leetcode.main.interval1.q23;

/**
 * 合并K个排序链表
 * 两个两个合并, ans和下一个链表合并
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-04
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list = mergeTwoLists(list, lists[i]);
        }
        return list;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1), before = dummyHead, current1 = list1, current2 = list2;
        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                before.next = current1;
                current1 = current1.next;
            } else {
                before.next = current2;
                current2 = current2.next;
            }
            before = before.next;
        }
        if (current1 != null) {
            before.next = current1;
        }
        if (current2 != null) {
            before.next = current2;
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
