package com.leetcode.main.interval1501.q1539;

/**
 * 第 k 个缺失的正整数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-27
 */
public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length - 1, cur;
        while (start < end) {
            cur = start + ((end - start) >> 1);
            int x = arr[cur] - cur - 1;
            if (x < k) {
                start = cur + 1;
            } else {
                end = cur;
            }
        }
        // 如果跳出循环的时候arr[start] - start - 1 >= k 不成立, 说明缺失值超过最后一个元素
        // 结果等于缺失的数量 + 第一个满足大于缺失值的位置索引号
        return arr[start] - start - 1 < k ? arr.length + k : start + k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }
}
