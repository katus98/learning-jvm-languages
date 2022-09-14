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

    /**
     * 两数相加
     * * 逐位相加, 注意进位
     *
     * @see com.leetcode.main.interval1.q2.Solution
     */
    void addTwoNumbers();

    /**
     * 两数相加 II
     * * 通过栈反转数字, 然后倒叙安置链表
     *
     * @see com.leetcode.main.interval401.q445.Solution
     */
    void addTwoNumbers2();

    /**
     * 相交链表
     * * 统计链表长度, 向后对齐, 然后同时遍历节点
     *
     * @see com.leetcode.main.interval101.q160.Solution
     */
    void getIntersectionNode();

    /**
     * 删除排序链表中的重复元素 II
     *
     * @see com.leetcode.main.interval1.q82.Solution
     */
    void deleteDuplicates();

    /**
     * 两两交换链表中的节点
     * * 伪头节点 + 两两遍历
     *
     * @see com.leetcode.main.interval1.q24.Solution
     */
    void swapPairs();

    /**
     * 重排链表
     * * 二分链表, 反转后半部分, 交替合并
     *
     * @see com.leetcode.main.interval101.q143.Solution
     */
    void reorderList();

    /**
     * 复制带随机指针的链表
     * * 通过一个map记录旧节点向新节点的映射关系
     *
     * @see com.leetcode.main.interval101.q138.Solution
     */
    void copyRandomList();

    /**
     * 旋转链表
     * * 统计链表长度进而计算需要把左侧几个节点放到尾部, 记录首尾指针
     *
     * @see com.leetcode.main.interval1.q61.Solution
     */
    void rotateRight();
}
