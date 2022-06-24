package com.leetcode.main.interval701.q740;

import java.util.*;

/**
 * 删除并获得点数
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-24
 */
public class Solution {
    /**
     * 排序 + DP
     * 统计每个相同数字的和
     * 排序形成多个连续递增的数组
     * 每个数组打家劫舍
     */
    public int deleteAndEarn(int[] nums) {
        int last = -1;
        // 从小到大排序
        Arrays.sort(nums);
        // 保证遍历顺序
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        // 统计数量
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        // 修改数据结构为多个连续递增数组
        List<List<Integer>> wholeList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (last + 1 != entry.getKey() && last != -1) {
                wholeList.add(list);
                list = new ArrayList<>();
            }
            list.add(entry.getValue());
            last = entry.getKey();
        }
        wholeList.add(list);
        // 所有的数组打家劫舍之后求和
        return getMaxScore(wholeList);
    }

    private int getMaxScore(List<List<Integer>> wholeList) {
        int score = 0;
        for (List<Integer> list : wholeList) {
            int[] dp = new int[list.size()];
            dp[0] = list.get(0);
            if (list.size() > 1) dp[1] = Math.max(list.get(0), list.get(1));
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 2] + list.get(i), dp[i - 1]);
            }
            score += dp[list.size() - 1];
        }
        return score;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
    }
}
