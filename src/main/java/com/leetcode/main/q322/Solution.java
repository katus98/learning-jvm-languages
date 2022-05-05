package com.leetcode.main.q322;

/**
 * 零钱兑换
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-05
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * 最小的零钱数量
     *
     * @param coins 几种面值的零钱
     * @param rem   剩下未破开的钱
     * @param count 结果数组 (记忆)
     */
    private int coinChange(int[] coins, int rem, int[] count) {
        // 如果剩下的钱小于0, 说明这种凑法凑不齐, 返回-1
        if (rem < 0) {
            return -1;
        }
        // 如果剩下的钱正好是0, 说明当前可以凑齐, 而且不再需要零钱了, 返回0
        if (rem == 0) {
            return 0;
        }
        // 如果剩下的钱的凑数已经有结果了直接返回结果
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        // 针对当前的钱, 每个零钱都参与破钱
        for (int coin : coins) {
            // 如果当前选择了coin面值则获取rem-coin的钱的凑法
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                // 获取这一轮中需要最少零钱的数量
                min = 1 + res;
            }
        }
        // 将结果更新到结果数组中
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
