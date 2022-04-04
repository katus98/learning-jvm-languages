package com.leetcode.main.q160;

/**
 * 相交链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-18
 * @see com.leetcode.offer.q52.Solution
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;
        ListNode cA = headA, cB = headB;
        while (cA != null) {
            cA = cA.next;
            countA++;
        }
        while (cB != null) {
            cB = cB.next;
            countB++;
        }
        cA = headA;
        cB = headB;
        int count = Math.abs(countA - countB);
        if (countA > countB) {
            while (count-- > 0) {
                cA = cA.next;
            }
        } else {
            while (count-- > 0) {
                cB = cB.next;
            }
        }
        while (cA != null && cB != null) {
            if (cA == cB) {
                return cA;
            }
            cA = cA.next;
            cB = cB.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
