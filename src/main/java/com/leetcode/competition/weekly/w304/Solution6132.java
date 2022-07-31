package com.leetcode.competition.weekly.w304;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SUN Katus
 * @version 1.0, 2022-07-31
 */
public class Solution6132 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) set.add(num);
        }
        return set.size();
    }
}
