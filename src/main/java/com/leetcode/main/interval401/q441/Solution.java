package com.leetcode.main.interval401.q441;

/**
 * 排列硬币
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
public class Solution {
    /**
     * 最基本的单向二分法之中间值靠右
     */
    public int arrangeCoins(int n) {
        int start = 1, end = n;
        long cur;
        while (start < end) {
            // +1 为了让cur计算结果靠右
            cur = start + ((end - start + 1) >> 1);
            long x = cur * (cur + 1) / 2;
            if (x > n) {
                end = (int) (cur - 1);
            } else {
                start = (int) (cur);
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(2));
    }
}
