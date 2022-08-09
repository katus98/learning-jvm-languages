package com.leetcode.main.interval1.q2;

/**
 * 两数相加
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), before = dummyHead;
        int res;
        boolean flag = false;
        while (l1 != null || l2 != null || flag) {
            res = 0;
            if (l1 != null) {
                res += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                res += l2.val;
                l2 = l2.next;
            }
            if (flag) {
                res++;
                flag = false;
            }
            if (res >= 10) {
                res -= 10;
                flag = true;
            }
            before.next = new ListNode(res);
            before = before.next;
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
