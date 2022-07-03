package com.leetcode.main.interval201.q217;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-03
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
