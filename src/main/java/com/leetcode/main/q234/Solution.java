package com.leetcode.main.q234;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-06
 */
public class Solution {
    /**
     * 遍历链表将数值放入数组中, 然后首位双指针判断回文
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i++).compareTo(list.get(j--)) != 0) {
                return false;
            }
        }
        return true;
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
