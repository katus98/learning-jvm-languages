package com.leetcode.main.interval301.q322;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-05
 */
public class Solution {
    /**
     * 记忆化搜索
     */
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * 记忆化搜索入口
     *
     * @param coins 几种面值的零钱
     * @param rem   剩下未破开的钱
     * @param count 结果数组 (记忆) 表示金额为i + 1的情况需要的最小零钱数量, 如果为0说明还没有计算
     */
    private int coinChange(int[] coins, int rem, int[] count) {
        // 如果当前剩余金额为负值, 说明当前凑法无法奏效
        if (rem < 0) return -1;
        // 如果当前剩余金额为0, 直接返回0
        if (rem == 0) return 0;
        // 如果结果数组中存在结果, 直接返回结果
        if (count[rem - 1] != 0) return count[rem - 1];
        // 开始破钱, min记录需要的最小数量
        int min = Integer.MAX_VALUE;
        // 针对每种面值进行破钱
        for (int coin : coins) {
            // 当前选择了coin面值, 剩下的金额递归获取数量
            int res = coinChange(coins, rem - coin, count);
            // 当前结果是res + 1, 但是只保留有效的最小值
            if (res != -1 && min > res + 1) {
                min = res + 1;
            }
        }
        // 将结果更新到结果数组中
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

    /**
     * DP 表示i金额破钱的最小张数
     * DP dp[i]等于每个零钱面值coin对应的dp[i - coin]中的最小值 + 1
     * d1DP: dp[i] = Math.min(dp[i], dp[i - coin] + 1)
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
