package com.leetcode.main.interval1301.q1356;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 根据数字二进制下 1 的数目排序
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-27
 */
public class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int c = Integer.compare(count1(o1), count1(o2));
                return c == 0 ? Integer.compare(o1, o2) : c;
            }

            private int count1(int n) {
                int count = 0;
                while (n != 0) {
                    n &= n - 1;
                    count++;
                }
                return count;
            }
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
