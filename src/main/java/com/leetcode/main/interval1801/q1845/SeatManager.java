package com.leetcode.main.interval1801.q1845;

import java.util.PriorityQueue;

/**
 * 座位预约管理系统
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-10
 */
public class SeatManager {
    private final PriorityQueue<Integer> queue;

    public SeatManager(int n) {
        this.queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
    }

    public int reserve() {
        return queue.poll();
    }

    public void unreserve(int seatNumber) {
        queue.offer(seatNumber);
    }
}
