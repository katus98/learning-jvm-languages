package com.leetcode.review;

/**
 * 经典数学问题
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public interface Mathematics {
    /**
     * 约瑟夫环
     * <a href="https://leetcode.cn/circle/article/BOoxAL/">约瑟夫环问题</a>
     */
    interface JosephRing {
        /**
         * 找出游戏的获胜者
         * * 队列模拟, 队首元素放到队尾
         * * 约瑟夫环
         *
         * @see com.leetcode.main.interval1801.q1823.Solution
         */
        void findTheWinner();
    }
}
