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

    /**
     * 最长递增子序列
     * * dp[i] = 符合条件的dp中最大的数 + 1
     * * d1DP: dp[i] = dp[j] + 1
     *
     * @see com.leetcode.main.interval201.q300.Solution
     */
    void lengthOfLIS();

    /**
     * 最长递增子序列的个数
     * * dp[i] = 符合条件的dp中最大的数 + 1
     * * count[i] = 同时记录某个位置结尾的最长子序列数量
     * * d1DP: dp[i] = dp[j] + 1
     *
     * @see com.leetcode.main.interval601.q673.Solution
     */
    void findNumberOfLIS();

    /**
     * 最大子数组和
     * * dp表示以当前元素结尾的最大子数组和
     * * d1DP: dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
     *
     * @see com.leetcode.main.interval1.q53.Solution
     */
    void maxSubArray();

    /**
     * 环形子数组的最大和
     * * 环形子数组的最大和 = Math.max(最大子数组和, 总和 - [1, n-2]最小子数组和)
     *
     * @see com.leetcode.main.interval901.q918.Solution
     */
    void maxSubarraySumCircular();

    /**
     * 最长公共子序列
     * * dp[i][j] 字符串1前i项和字符串2前j项形成的最长公共子序列
     * * d2DP: dp[i][j] = dp[i - 1][j - 1] + 1 (text1.charAt(i - 1) == text2.charAt(j - 1))
     * * d2DP: dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) (text1.charAt(i - 1) != text2.charAt(j - 1))
     *
     * @see com.leetcode.main.interval1101.q1143.Solution
     */
    void longestCommonSubsequence();

    /**
     * 两个字符串的删除操作
     * * dp[i][j] 字符串1前i项和字符串2前j项形成同样字符串需要删除的操作数
     * * d2DP: dp[i][j] = dp[i - 1][j - 1] (text1.charAt(i - 1) == text2.charAt(j - 1))
     * * d2DP: dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 2) (text1.charAt(i - 1) != text2.charAt(j - 1))
     *
     * @see com.leetcode.main.interval501.q583.Solution
     */
    void minDistance();

    /**
     * 乘积最大子数组
     * * 以i结尾的乘积最大值等于前一位的最大值*当前位置, 当前位置, 前一位最小值*当前位置 三者最大值
     * * d1DP: maxF[i] = Math.max(maxF[i - 1] * nums[i], nums[i], minF[i - 1] * nums[i])
     * * d1DP: minF[i] = Math.min(minF[i - 1] * nums[i], nums[i], maxF[i - 1] * nums[i])
     *
     * @see com.leetcode.main.interval101.q152.Solution
     */
    void maxProduct();

    /**
     * 乘积为正数的最长子数组长度
     * * 表示以当前位置结尾的乘积为正/负数的最长子数组长度
     * * d1DP: 根据当前元素正负和dp[i-1]的情况分类讨论即可
     *
     * @see com.leetcode.main.interval1501.q1567.Solution
     */
    void getMaxLen();
}
