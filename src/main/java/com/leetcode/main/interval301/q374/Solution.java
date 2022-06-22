package com.leetcode.main.interval301.q374;

/**
 * 猜数字大小
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-22
 */
public class Solution extends GuessGame {
    /**
     * 最基本的二分查找
     */
    public int guessNumber(int n) {
        int start = 1, end = n, cur;
        while (start < end) {
            cur = start + ((end - start) >> 1);
            int guess = guess(cur);
            if (guess == -1) {
                end = cur;
            } else if (guess == 1) {
                start = cur + 1;
            } else {
                start = cur;
                end = cur;
            }
        }
        // 根据题意一定可以找到, 所以不需要判断
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.guessNumber(15));
    }
}
