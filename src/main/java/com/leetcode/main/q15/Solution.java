package com.leetcode.main.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-29
 */
public class Solution {
    /**
     * 先排序, 固定第一位, 然后固定第二位, 第三位反向扫描
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            for (int second = first + 1; second < nums.length - 1; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = nums.length - 1;
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    list.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return list;
    }
}
