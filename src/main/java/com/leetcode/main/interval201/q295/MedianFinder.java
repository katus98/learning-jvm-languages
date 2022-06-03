package com.leetcode.main.interval201.q295;

import com.leetcode.offer.q41.MedianFinder2;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 * @see com.leetcode.offer.q41.MedianFinder
 * @see MedianFinder2
 */
public class MedianFinder {
    // 最小堆放大的一半, 最小堆放大的一半
    private final PriorityQueue<Integer> minQueue;
    private final PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        this.minQueue = new PriorityQueue<>();
        this.maxQueue = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        if (minQueue.size() == maxQueue.size()) {
            // 两边一样多让最小队列多一个, 放到最大堆里, 然后将最大堆最大值放到最小堆
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        } else {
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        }
    }

    public double findMedian() {
        if (size() == 0) {
            return 0;
        } else if (minQueue.size() == maxQueue.size()) {
            return 1.0 * (minQueue.peek() + maxQueue.peek()) / 2.0;
        } else {
            return minQueue.peek();
        }
    }

    public int size() {
        return minQueue.size() + maxQueue.size();
    }
}
