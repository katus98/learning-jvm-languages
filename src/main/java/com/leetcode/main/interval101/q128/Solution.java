package com.leetcode.main.interval101.q128;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-10
 */
public class Solution {
    /**
     * 哈希
     * 将所有的元素放入哈希集合中, 遍历每一个不存在小一的元素, 验证他有多少个+1在哈希表里面
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestSer = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int count = 1;
                int current = num;
                while (numSet.contains(current + 1)) {
                    current++;
                    count++;
                }
                if (count > longestSer) longestSer = count;
            }
        }
        return longestSer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
