package com.leetcode.main.interval201.q202;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-30
 */
public class Solution {
    private final Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (set.contains(n)) return false;
        set.add(n);
        int nex = 0;
        while (n > 0) {
            int x = n % 10;
            nex += x * x;
            n /= 10;
        }
        return isHappy(nex);
    }
}
