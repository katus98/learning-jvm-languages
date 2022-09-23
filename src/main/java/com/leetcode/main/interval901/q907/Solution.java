package com.leetcode.main.interval901.q907;

/**
 * 子数组的最小值之和
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-23
 */
public class Solution {
    private final static int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int k, start, end;
        long count = 0L, c;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // 从当前位置向左右找到以当前值为最小值的区间范围, 一侧有等号, 一侧没有
            k = i + 1;
            while (k < arr.length && arr[k] > num) {
                k++;
            }
            end = k;
            k = i - 1;
            while (k >= 0 && arr[k] >= num) {
                k--;
            }
            start = k;
            c = ((long) (end - i) * (i - start) * num) % MOD;
            count += c;
        }
        return (int) (count % MOD);
    }

    public int sumSubarrayMins2(int[] arr) {
        int[] dp = new int[arr.length + 1];
        int[] stack = new int[arr.length + 1];
        int top = -1;
        // 初始化
        stack[++top] = -1;
        dp[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            // 构建单调递增栈
            while (top > 0 && arr[i] <= arr[stack[top]]) {
                top--;
            }
            // dp[stack[top] + 1]是不受影响的子区间的最小值之和
            // i - stack[top]是以当前元素为最小值的子区间数量
            dp[i + 1] = (dp[stack[top] + 1] + (i - stack[top]) * arr[i]) % MOD;
            stack[++top] = i; //入栈
        }

        int res = 0;
        for (int i = 0; i <= arr.length; i++) {
            res += dp[i];
            res %= MOD;
        }
        return res;
    }
}
