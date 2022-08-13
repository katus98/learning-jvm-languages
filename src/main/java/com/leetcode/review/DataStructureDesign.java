package com.leetcode.review;

/**
 * 数据结构的设计
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-17
 */
public interface DataStructureDesign {
    /**
     * 用栈实现队列
     *
     * @see com.leetcode.main.interval201.q232.MyQueue
     */
    void stackToQueue();

    /**
     * 设计哈希映射
     *
     * @see com.leetcode.main.interval701.q706.MyHashMap
     */
    void hashMap();

    /**
     * 设计链表
     *
     * @see com.leetcode.main.interval701.q707.MyLinkedList
     */
    void myLinkedList();

    /**
     * O(1) 时间插入、删除和获取随机元素
     * * 哈希表记录元素在数组中的位置, 数组记录数据用来生成随机元素, 删除时将最后的元素放到需要删除的位置并更新位置信息
     *
     * @see com.leetcode.main.interval301.q380.RandomizedSet
     */
    void randomizedSet();

    /**
     * 最小栈
     * * 通过一个额外的栈, 每次发现有最小值就压入, 每次弹出就查看是否与栈顶一致
     *
     * @see com.leetcode.main.interval101.q155.MinStack
     */
    void minStack();
}
