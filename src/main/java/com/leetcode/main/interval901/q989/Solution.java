package com.leetcode.main.interval901.q989;

import java.util.LinkedList;
import java.util.List;

/**
 * 数组形式的整数加法
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-26
 */
public class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> resList = new LinkedList<>();
        int i = num.length - 1, n = k, addFront = 0;
        while (i >= 0 && n > 0) {
            int a = num[i];
            int b = n % 10;
            int res = a + b + addFront;
            if (res >= 10) {
                res -= 10;
                addFront = 1;
            } else {
                addFront = 0;
            }
            resList.addFirst(res);
            i--;
            n /= 10;
        }
        while (i >= 0) {
            int a = num[i];
            int res = a + addFront;
            if (res >= 10) {
                res -= 10;
                addFront = 1;
            } else {
                addFront = 0;
            }
            resList.addFirst(res);
            i--;
        }
        while (n > 0) {
            int b = n % 10;
            int res = b + addFront;
            if (res >= 10) {
                res -= 10;
                addFront = 1;
            } else {
                addFront = 0;
            }
            resList.addFirst(res);
            n /= 10;
        }
        if (addFront == 1) {
            resList.addFirst(1);
        }
        return resList;
    }
}
