package com.leetcode.main.q278;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * 
 * @author SUN Katus
 * @version 1.0, 2022-03-03
 */
public class Solution {

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    boolean isBadVersion(int version) {
        if (version < 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(10));
    }
}