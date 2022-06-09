package com.leetcode.main.interval401.q445;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 两数相加 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-09
 */
public class Solution {
    /**
     * 栈
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> n1 = new LinkedList<>(), n2 = new LinkedList<>();
        ListNode cur = l1;
        while (cur != null) {
            n1.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            n2.push(cur.val);
            cur = cur.next;
        }
        int add1 = 0;
        while (n1.size() > 0 || n2.size() > 0) {
            int p1 = n1.size() > 0 ? n1.pop() : 0;
            int p2 = n2.size() > 0 ? n2.pop() : 0;
            int num = p1 + p2 + add1;
            if (num > 9) {
                cur = new ListNode(num - 10, cur);
                add1 = 1;
            } else {
                cur = new ListNode(num, cur);
                add1 = 0;
            }
        }
        if (add1 == 1) {
            cur = new ListNode(add1, cur);
        }
        return cur;
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
