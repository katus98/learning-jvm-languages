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

    /**
     * 删除链表的倒数第 N 个结点
     * * 先向后走n步, 然后设置一个新的指针和之前的同步走, 直到先走的指针走到最后, 后走的指针就是倒数第n
     *
     * @see com.leetcode.main.interval1.q19.Solution
     */
    void removeNthFromEnd();

    /**
     * 回文链表
     * * 遍历链表将数值放入数组中, 然后首位双指针判断回文
     * * 链表通过快慢指针分成前后两部分, 后部分反转, 然后依次比较元素
     *
     * @see com.leetcode.main.interval201.q234.Solution
     */
    void isPalindrome();

    /**
     * 奇偶链表
     * * 维护两个头, 交替与两个头连接
     *
     * @see com.leetcode.main.interval301.q328.Solution
     */
    void oddEvenList();

    /**
     * 排序链表
     * * 归并排序
     *
     * @see com.leetcode.main.interval101.q148.Solution
     */
    void sortList();
}
