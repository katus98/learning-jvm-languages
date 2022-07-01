package com.leetcode.main.interval401.q413;

/**
 * 等差数列划分
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class Solution {
    /**
     * 差分 + 计数
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int[] deltaArr = new int[nums.length - 1];
        for (int i = 0; i < deltaArr.length; i++) {
            deltaArr[i] = nums[i + 1] - nums[i];
        }
        int last = Integer.MAX_VALUE, count = 0, total = 0;
        for (int delta : deltaArr) {
            // 如果当前差值与前一项差值相等则开始计数
            if (delta == last) {
                count++;
            } else {
                count = 0;   // 不相等归零
            }
            // 每次计数都要叠加以保证不重复
            total += count;
            last = delta;
        }
        return total;
    }

    /**
     * DP 以当前项目为结尾的等差数列的个数
     * 结果相加即可
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        int count = 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            count += dp[i];
        }
        return count;
    }
}
