package com.leetcode.main.interval301.q334;

/**
 * 递增的三元子序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-04
 */
public class Solution {
    /**
     * 双向遍历得到每个元素前面最小值和后面最大值
     */
    public boolean increasingTriplet(int[] nums) {
        int[] minPre = new int[nums.length], maxPost = new int[nums.length];
        minPre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minPre[i] = Math.min(nums[i], minPre[i - 1]);
        }
        maxPost[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxPost[i] = Math.max(nums[i], maxPost[i + 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > minPre[i] && nums[i] < maxPost[i]) return true;
        }
        return false;
    }

    /**
     * 贪心
     */
    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
