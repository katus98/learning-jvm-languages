package com.leetcode.competition.weekly.w300;

/**
 * 知道秘密的人数
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-03
 */
public class Solution6109 {
    private final int MOD = 1000000007;

    /**
     * DP 表示i天新知道的人的数量, 等于 (i - forget, i - delay] 区间内新增加的人数之和
     * trie DP的前缀和
     * 结果是[n - forget + 1, n]的新增加人数之和
     */
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1], trie = new long[n + 1];
        dp[1] = trie[1] = 1;
        for (int i = 2; i <= n; i++) {
            int left = Math.max(0, i - forget);
            int right = Math.max(0, i - delay);
            dp[i] = (trie[right] - trie[left] + MOD) % MOD;
            trie[i] = (trie[i - 1] + dp[i]) % MOD;
        }
        return (int) ((trie[n] - trie[Math.max(0, n - forget)] + MOD) % MOD);
    }

    public static void main(String[] args) {
        Solution6109 solution6109 = new Solution6109();
        System.out.println(solution6109.peopleAwareOfSecret(6, 2, 4));
    }
}
