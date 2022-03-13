package com.leetcode.offer.q25;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-11
 */
public class Solution {
    /**
     * 伪头节点 + 双指针
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current1 = l1, current2 = l2, fakeFirst = new ListNode(-1), current = fakeFirst;
        while (current1 != null || current2 != null) {
            if (current1 != null && current2 != null) {
                if (current1.val < current2.val) {
                    current.next = current1;
                    current1 = current1.next;
                } else {
                    current.next = current2;
                    current2 = current2.next;
                }
            } else if (current1 != null) {
                current.next = current1;
                current1 = current1.next;
            } else {
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }
        return fakeFirst.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode current1 = l1, current2 = l2, fakeFirst = new ListNode(-1), current = fakeFirst;
        while (current1 != null || current2 != null) {
            if (current1 != null && current2 != null) {
                if (current1.val < current2.val) {
                    current.next = current1;
                    current1 = current1.next;
                } else {
                    current.next = current2;
                    current2 = current2.next;
                }
            } else if (current1 != null) {
                // 处理剩余尾部直接接过来就好, 不需要一个一个接了
                current.next = current1;
                break;
            } else {
                current.next = current2;
                break;
            }
            current = current.next;
        }
        return fakeFirst.next;
    }

    /**
     * 递归
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
