package com.leetcode.exam.autumn.pre.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-15
 */
public class Test {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }
        for (int i = 1; i <= A.length; i++) {
            if (!set.contains(i)) return i;
        }
        return A.length + 1;
    }
}
