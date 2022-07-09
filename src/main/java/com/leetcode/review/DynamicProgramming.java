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
     * 编辑距离
     * * dp[i][j] 字符串1前i项和字符串2前j项形成同样字符串需要的操作数
     * * 当i或者j为0时, dp的数值等于另一个不为0的索引值
     * * dp的值是由左侧、下侧和左下侧的数值决定的, 左侧和下侧都是通过插入删除元素实现, 因此必然+1, 左下侧是通过替换元素来实现, 如果下一位恰好相等, 就不需要+1了
     * * d2DP: left = left + 1, down = down + 1, ld = text1.charAt(i - 1) != text2.charAt(j - 1) ? ld + 1 : ld
     * * d2DP: dp[i][j] = left < down ? Math.min(left, ld) : Math.min(down, ld)
     *
     * @see com.leetcode.main.interval1.q72.Solution
     */
    void minDistance2();

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

    /**
     * 零钱兑换
     * * DP 表示i金额破钱的最小张数
     * * DP dp[i]等于每个零钱面值coin对应的dp[i - coin]中的最小值 + 1
     * * d1DP: dp[i] = Math.min(dp[i], dp[i - coin] + 1)
     *
     * @see com.leetcode.main.interval301.q322.Solution
     */
    void coinChange();

    /**
     * 最佳观光组合
     * * DP 求 values[i] + i + values[j] - j 的最大值相当于更新values[i] + i最大值同时遍历j即可
     *
     * @see com.leetcode.main.interval1001.q1014.Solution
     */
    void maxScoreSightseeingPair();

    /**
     * 买卖股票的最佳时机
     * * 遍历整个序列, 最大利润一定出现在当前价格卖出, 当前之前的最低价格买入
     *
     * @see com.leetcode.main.interval101.q121.Solution
     */
    void maxProfit();

    /**
     * 买卖股票的最佳时机 II
     * * DP: 表示第i天持有股票/不持有股票的最大利润
     * * 第i天不持有股票的最大利润是前一天不持有股票的最大利润和前一天持有股票今天卖出的最大值
     * * d1DP: dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
     * * 第i天持有股票的最大利润是前一天持有股票的最大利润和前一天没股票今天买入的最大值
     * * d1DP: dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
     *
     * @see com.leetcode.main.interval101.q122.Solution
     */
    void maxProfit2();

    /**
     * 最佳买卖股票时机含冷冻期
     * * DP
     * * 持有股票则前一天持有股票/前一天没有未冻结今天买入
     * * d1DP: dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i])
     * * 不持有股票冻结说明前一天卖出了股票
     * * d1DP: dp[i][1] = dp[i - 1][0] + prices[i]
     * * 不持有股票不冻结则是前一天不持有股票的最大值
     * * d1DP: dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2])
     *
     * @see com.leetcode.main.interval301.q309.Solution
     */
    void maxProfitF();

    /**
     * 买卖股票的最佳时机含手续费
     * * DP 与买卖股票的最佳时机 II 做法相同
     *
     * @see com.leetcode.main.interval701.q714.Solution
     */
    void maxProfitT();

    /**
     * 单词拆分
     * * DP: 前i个字符是否可以被单词集合中的单词组成
     * * d1DP: dp[i] = dp[j] && wordSet.contains(s.substring(j, i))
     *
     * @see com.leetcode.main.interval101.q139.Solution
     */
    void wordBreak();

    /**
     * 接雨水
     * * DP i位置的水高度取决于i向左向右的最大高度中的最小值减去i位置的高度
     * * d1DP: maxLeft[i] = Math.max(maxLeft[i - 1], height[i])
     * * d1DP: maxRight[i] = Math.max(maxRight[i + 1], height[i])
     * * d1DP: val[i] = Math.min(maxLeft[i], maxRight[i]) - height[i]
     *
     * @see com.leetcode.main.interval1.q42.Solution
     */
    void trap();

    /**
     * 等差数列划分
     * * DP 以i元素结尾的等差数列的数量
     * * d1DP: dp[i] = dp[i - 1] + 1 (当 nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1])
     *
     * @see com.leetcode.main.interval401.q413.Solution
     */
    void numberOfArithmeticSlices();

    /**
     * 解码方法
     * * DP 表示长度为i的s前缀所能形成的解码个数
     * * d1DP: dp[i] += dp[i - 1] (当i是一个有效的解码时)
     * * d1DP: dp[i] += dp[i - 2] (当i与i-1组合是一个有效的解码时)
     *
     * @see com.leetcode.main.interval1.q91.Solution
     */
    void numDecodings();

    /**
     * 丑数 II
     * * DP 第i个丑数
     * * d1DP: dp[i] = Math.min(2 * dp[n1], 3 * dp[n2], 5 * dp[n3])
     *
     * @see com.leetcode.main.interval201.q264.Solution
     */
    void nthUglyNumber2();

    /**
     * 不同的二叉搜索树
     * * DP: 表示n个数所可以形成的二叉搜索树数量
     * * d1DP: dp[i] += dp[j] * dp[i - j - 1] (j表示左子树节点数, 0<=j<i)
     *
     * @see com.leetcode.main.interval1.q96.Solution
     */
    void numTrees();

    /**
     * 矩阵区域和
     * * DP: 表示以当前元素为右下角, 矩阵左上角为左上角的矩形的和
     * * d2DP: dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j]
     * * answer = DP右下角 - DP右上角 - DP左下角 + DP左上角
     *
     * @see com.leetcode.main.interval1301.q1314.Solution
     */
    void matrixBlockSum();

    /**
     * 二维区域和检索 - 矩阵不可变
     * * DP: 二维左上角前缀和
     * * d2DP: dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j]
     *
     * @see com.leetcode.main.interval301.q304.NumMatrix
     */
    void sumRegion();

    /**
     * 三角形最小路径和
     * * DP 表示以当前元素结尾的最小路径和
     * * d2DP: dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j)
     *
     * @see com.leetcode.main.interval101.q120.Solution
     */
    void minimumTotal();

    /**
     * 下降路径最小和
     * * DP 表示以当前元素结尾的最小路径和
     * * d2DP: dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1], dp[i - 1][j - 1])
     *
     * @see com.leetcode.main.interval901.q931.Solution
     */
    void minFallingPathSum();

    /**
     * 不同路径
     * * DP 到达当前位置的路径总和 (上方+左方)
     * * d2DP: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     *
     * @see com.leetcode.main.interval1.q62.Solution
     */
    void uniquePaths();

    /**
     * 不同路径 II
     * * 到达当前位置的路径总和 (上方+左方)
     * * d2DP: dp[i][j] = dp[i - 1][j] + dp[i][j - 1] (当前位置不是障碍物)
     * * d2DP: dp[i][j] = 0 (当前位置是障碍物)
     *
     * @see com.leetcode.main.interval1.q63.Solution
     */
    void uniquePathsWithObstacles();

    /**
     * 最小路径和
     * * DP 到达当前位置的最小路径和
     * * d2DP: dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
     *
     * @see com.leetcode.main.interval1.q64.Solution
     */
    void minPathSum();

    /**
     * 最大正方形
     * * DP 以当前位置为右下角的最大正方形边长
     * * d2DP: dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
     *
     * @see com.leetcode.main.interval201.q221.Solution
     */
    void maximalSquare();

    /**
     * 最长回文子序列
     * * DP 表示[i, j]最长回文序列长度
     * * d2DP: dp[i][j] = dp[i + 1][j - 1] + 2 (s[i]==s[j])
     * * d2DP: dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]) (s[i]!=s[j])
     *
     * @see com.leetcode.main.interval501.q516.Solution
     */
    void longestPalindromeSubseq();

    /**
     * 摆动序列
     * * DP 表示到i为止的前缀中递增/递减结尾的摆动序列长度最大值
     * * d1DP: up[i] = Math.max(up[i - 1], down[i - 1] + 1) / down[i] = Math.max(up[i - 1] + 1, down[i - 1])
     *
     * @see com.leetcode.main.interval301.q376.Solution
     */
    void wiggleMaxLength();
}
