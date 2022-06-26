package com.leetcode.main.interval201.q278;

/**
 * 第一个错误的版本
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {
    /**
     * 最基本的二分查找, 单向查找, 退出条件就是结果
     */
    public int firstBadVersion(int n) {
        int start = 1, end = n, cur;
        while (start < end) { // 循环直至区间左右端点相同
            cur = start + ((end - start) >> 1); // 防止计算时溢出
            if (isBadVersion(cur)) {
                end = cur; // 答案在区间 [start, cur] 中
            } else {
                start = cur + 1; // 答案在区间 [cur+1, end] 中
            }
        }
        // 此时有 start == end，区间缩为一个点，即为答案
        return start;
    }

    private boolean isBadVersion(int version) {
        return version >= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(10));
    }
}
