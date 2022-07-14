package com.leetcode.main.interval1901.q1991;

/**
 * 找到数组的中间位置
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-14
 * @see com.leetcode.main.interval701.q724.Solution
 */
public class Solution {
    /**
     * 前缀和
     */
    public int findMiddleIndex(int[] nums) {
        com.leetcode.main.interval701.q724.Solution solution = new com.leetcode.main.interval701.q724.Solution();
        return solution.pivotIndex(nums);
    }
}
