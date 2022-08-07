package com.leetcode.competition.weekly.w305;

import java.util.HashSet;
import java.util.Set;

/**
 * 算术三元组的数目
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-07
 */
public class Solution6136 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0, theCount;
        Set<Integer> set = new HashSet<>(), hasSet = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (hasSet.contains(num)) continue;
            theCount = 0;
            int theNum = num;
            while (set.contains(theNum)) {
                theCount++;
                hasSet.add(theNum);
                theNum = theNum + diff;
            }
            if (theCount >= 3) {
                count += theCount - 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution6136 solution6136 = new Solution6136();
        System.out.println(solution6136.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
    }
}
