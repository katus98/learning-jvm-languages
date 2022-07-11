package com.leetcode.main.interval501.q518;

import java.util.Arrays;

/**
 * 零钱兑换 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-31
 */
public class Solution {
    private int count;

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        this.count = 0;
        dfs(amount, coins, 0, 0);
        return count;
    }

    /**
     * DFS 超时
     */
    private void dfs(int amount, int[] coins, int current, int index) {
        if (current > amount) return;
        if (current == amount) {
            count++;
        } else {
            for (int i = index; i < coins.length; i++) {
                dfs(amount, coins, current + coins[i], i);
            }
        }
    }

    /**
     * DP 背包问题
     * 一定要注意硬币是外层循环否则会重复
     */
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
