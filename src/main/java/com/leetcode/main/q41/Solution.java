package com.leetcode.main.q41;

/**
 * 缺失的第一个正数
 *
 * @author SUN Katus
 * @version 1.0, 2022-04-22
 */
public class Solution {
    /**
     * 通过数组下标+1对应的数有没有出现过来设置值的正负
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length, x;
        // 将所有的1-N范围外的数设置为N+1
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        // 如果发现当前数字在1-N中而且没有出现过, 则标记(将下标-1对应的数取反)
        for (int i = 0; i < length; i++) {
            x = Math.abs(nums[i]);
            if (x >= 1 && x <= length && nums[x - 1] > 0) {
                nums[x - 1] *= -1;
            }
        }
        // 返回最左侧非零的下标+1
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 否则返回N+1
        return length + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
