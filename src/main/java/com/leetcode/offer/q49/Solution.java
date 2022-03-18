package com.leetcode.offer.q49;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-18
 */
public class Solution {
    /**
     * 最小堆, 每次弹出一个最小值, 放入一个这个值的235倍, 注意去重
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        while (n > 0) {
            long res = heap.poll();
            if (n == 1) return (int) res;
            if (!set.contains(2 * res)) {
                set.add(2 * res);
                heap.offer(2 * res);
            }
            if (!set.contains(3 * res)) {
                set.add(3 * res);
                heap.offer(3 * res);
            }
            if (!set.contains(5 * res)) {
                set.add(5 * res);
                heap.offer(5 * res);
            }
            n--;
        }
        return 1;
    }

    /**
     * dp 判断各自位置的235倍的最小值, 选中的位置到下一个位置
     */
    public int nthUglyNumber2(int n) {
        int[] array = new int[n];
        array[0] = 1;
        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 1; i < n; i++) {
            array[i] = Math.min(Math.min(2 * array[n1], 3 * array[n2]), 5 * array[n3]);
            if (2 * array[n1] == array[i]) {
                n1++;
            }
            if (3 * array[n2] == array[i]) {
                n2++;
            }
            if (5 * array[n3] == array[i]) {
                n3++;
            }
        }
        return array[n - 1];
    }

    private int compute(int n1, int n2, int n3) {
        return power(2, n1) * power(3, n2) * power(5, n3);
    }

    private int power(int x, int n) {
        if (n == 0) return 1;
        int res = x;
        for (int i = 0; i < n - 1; i++) {
            res *= x;
        }
        return res;
    }
}
