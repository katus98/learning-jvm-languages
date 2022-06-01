package com.leetcode.main.interval501.q560;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-01
 */
public class Solution {
    /**
     * 前缀和 + 哈希表
     * 以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]-k 的 pre[j] 即可
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, result = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
