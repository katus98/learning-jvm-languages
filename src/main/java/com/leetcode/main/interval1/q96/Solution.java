package com.leetcode.main.interval1.q96;

/**
 * 不同的二叉搜索树
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-02
 */
public class Solution {
    /**
     * DP: 表示n个数所可以形成的二叉搜索树数量
     * dp[i] += dp[j] * dp[i - j - 1] (j表示左子树节点数, 0<=j<i)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
