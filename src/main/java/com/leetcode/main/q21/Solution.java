package com.leetcode.main.q21;

/**
 * 合并两个有序链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-11
 * @see com.leetcode.offer.q25.Solution
 */
public class Solution {
    /**
     * 三个指针, 分别指向最终链表节点, 两个链表结点
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current1 = list1, current2 = list2, fakeFirst = new ListNode(-1), current = fakeFirst;
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
