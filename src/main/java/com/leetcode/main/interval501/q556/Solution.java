package com.leetcode.main.interval501.q556;

/**
 * 下一个更大元素 III
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-20
 * @see com.leetcode.main.interval1.q31.Solution
 */
public class Solution {
    /**
     * 下一个排列
     */
    public int nextGreaterElement(int n) {
        char[] str = String.valueOf(n).toCharArray();
        int small, big;
        for (small = str.length - 2; small >= 0; small--) {
            if (str[small] < str[small + 1]) break;
        }
        if (small < 0) return -1;
        for (big = str.length - 1; big >= small + 1; big--) {
            if (str[big] > str[small]) break;
        }
        swap(str, small, big);
        reverse(str, small + 1, str.length - 1);
        int res = 0;
        for (char c : str) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10)) {
                return -1;
            }
            res *= 10;
            res += c - '0';
        }
        return res;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(char[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(2147483476));
    }
}
