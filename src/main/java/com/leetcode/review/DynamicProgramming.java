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

    /**
     * 打家劫舍
     * * dp表示偷到前i家最大金钱数
     * * d1DP: dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
     *
     * @see com.leetcode.main.interval101.q198.Solution
     */
    void rob();

    /**
     * 打家劫舍 II
     * * dp表示偷到前i家最大金钱数
     * * 分别求区间[0,n-2]与区间[1,n-1]的关系
     * * d1DP: dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
     *
     * @see com.leetcode.main.interval101.q198.Solution
     */
    void rob2();

    /**
     * 删除并获得点数
     * * 排序后形成多个连续递增数组, 每一个数组进行DP
     * * DP递推关系与打家劫舍一致
     * * d1DP: dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
     *
     * @see com.leetcode.main.interval701.q740.Solution
     */
    void deleteAndEarn();
}
