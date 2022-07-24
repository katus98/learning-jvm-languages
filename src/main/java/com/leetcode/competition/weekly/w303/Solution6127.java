package com.leetcode.competition.weekly.w303;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 优质数对的数目
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-24
 */
public class Solution6127 {
    /**
     * 数学
     * 双指针找数对
     */
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        nums = set.stream().mapToInt(Integer::intValue).toArray();
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counts[i] = count1(nums[i]);
        }
        long res = 0L;
        Arrays.sort(counts);
        // i 从前向后扫, j 从后向前扫。
        // i 每次向后挪动一步, j 每次可能不挪到或者挪动一步或多步
        for (int i = 0, j = counts.length - 1; i < counts.length; i++) {
            // 尝试挪动 j，直到 j 满足区间 (j, n) 内的数字都能和 i 凑成优质数对。
            while (j >= 0 && counts[i] + counts[j] >= k) {
                j--;
            }
            // 累计答案。
            res += counts.length - j - 1;
        }
        return res;
    }

    private int count1(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution6127 solution6127 = new Solution6127();
        System.out.println(solution6127.countExcellentPairs(new int[]{1, 2, 3, 1}, 3));
    }
}
