package com.leetcode.offer.q61;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-21
 */
public class Solution {

    public boolean isStraight(int[] nums) {
        int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
                if (maxNum < num) maxNum = num;
                if (minNum > num) minNum = num;
            }
        }
        HashSet<Integer> set = new HashSet<>(list);
        return set.size() == list.size() && maxNum - minNum <= 4;
    }
}
