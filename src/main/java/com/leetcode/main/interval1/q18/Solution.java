package com.leetcode.main.interval1.q18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-18
 */
public class Solution {
    /**
     * 排序 + 四层循环 (最后一层倒序)
     * 注意可能出现的int溢出
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) return list;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                for (int third = second + 1; third < nums.length - 1; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    int fourth = nums.length - 1;
                    while (fourth > third) {
                        long total = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
                        if (total == target) {
                            list.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                            break;
                        }
                        if (total > target) {
                            fourth--;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
