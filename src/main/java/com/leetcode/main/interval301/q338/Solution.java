package com.leetcode.main.interval301.q338;

import java.util.Arrays;

/**
 * 比特位计数
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-11
 */
public class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {   // 如果i是2的整数幂, 归0
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(5)));
    }
}
