package com.leetcode.offer.q41;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过简单的排序数组来实现
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-17
 */
public class MedianFinder {
    private final List<Integer> data;

    public MedianFinder() {
        this.data = new ArrayList<>();
    }

    public void addNum(int num) {
        int start = 0, end = size(), i;
        while (start < end) {
            i = start + (end - start) / 2;
            if (num < data.get(i)) {
                end = i;
            } else if (num > data.get(i)) {
                start = i + 1;
            } else {
                start = i;
                end = i;
            }
        }
        i = start + (end - start) / 2;
        data.add(i, num);
    }

    public double findMedian() {
        if (size() % 2 == 1) {
            return data.get(size() / 2);
        } else if (size() != 0) {
            return 1.0 * (data.get(size() / 2) + data.get(size() / 2 - 1)) / 2.0;
        } else {
            return 0;
        }
    }

    public int size() {
        return data.size();
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}
