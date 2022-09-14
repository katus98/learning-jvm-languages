package com.leetcode.main.interval401.q461;

/**
 * 汉明距离
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-14
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int dis = 0;
        while (x > 0 || y > 0) {
            dis += ((x & 1) ^ (y & 1));
            x >>= 1;
            y >>= 1;
        }
        return dis;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(1, 4));
    }
}
