package com.leetcode.main.interval1801.q1823;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找出游戏的获胜者
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-13
 */
public class Solution {
    /**
     * 队列模拟, 队首元素放到队尾
     */
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < k; j++) {
                Integer ele = queue.poll();
                queue.offer(ele);
            }
            queue.poll();
        }
        return queue.poll();
    }

    public int findTheWinner2(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinner2(n - 1, k) - 1) % n + 1;
    }

    public int findTheWinner3(int n, int k) {
        int winner = 1;
        for (int i = 2; i <= n; i++) {
            winner = (k + winner - 1) % i + 1;
        }
        return winner;
    }
}
