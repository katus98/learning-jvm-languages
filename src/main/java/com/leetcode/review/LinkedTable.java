package com.leetcode.review;

/**
 * 链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-17
 */
public interface LinkedTable {
    /**
     * 反转链表
     * * pre=最后, cur=head, nex=cur.next, cur.next=pre, pre=cur, cur=nex
     *
     * @see com.leetcode.main.interval201.q206.Solution
     */
    void reverseList();

    /**
     * K 个一组翻转链表
     * * 反转链表的基础上统筹处理
     *
     * @see com.leetcode.main.interval1.q25.Solution
     */
    void reverseKGroup();

    /**
     * 合并K个排序链表
     * * 每个链表和结果链表两两合并
     *
     * @see com.leetcode.main.interval1.q23.Solution
     */
    void mergeKLists();

    /**
     * 链表的中间结点
     * * 快慢指针
     *
     * @see com.leetcode.main.interval801.q876.Solution
     */
    void middleNode();

    /**
     * 环形链表 II
     * * 数学推导 + 快慢指针
     *
     * @see com.leetcode.main.interval101.q142.Solution
     */
    void detectCycle();
}
