package com.leetcode.review;

/**
 * 动态规划
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-22
 */
public interface DynamicProgramming {
    /**
     * 斐波那契数
     * * d1DP: dp[i] = dp[i - 1] + dp[i - 2]
     *
     * @see com.leetcode.main.interval501.q509.Solution
     */
    void fib();

    /**
     * 第 N 个泰波那契数
     * * d1DP: dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
     *
     * @see com.leetcode.main.interval1101.q1137.Solution
     */
    void tribonacci();

    /**
     * 爬楼梯
     * * d1DP: dp[i] = dp[i - 1] + dp[i - 2]
     *
     * @see com.leetcode.main.interval1.q70.Solution
     */
    void climbStairs();

    /**
     * 使用最小花费爬楼梯
     * * d1DP: dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
     *
     * @see com.leetcode.main.interval701.q746.Solution
     */
    void minCostClimbingStairs(int[] cost);
}
