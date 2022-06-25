package com.leetcode.main.interval1.q45;

import java.util.Arrays;

/**
 * 跳跃游戏 II
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-19
 */
public class Solution {
    /**
     * 原创 DP
     * 正向跳跃, 维护一个到达位置最小跳数的数组
     */
    public int jump(int[] nums) {
        int[] step = new int[nums.length];
        Arrays.fill(step, Integer.MAX_VALUE);
        step[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (step[i] == Integer.MAX_VALUE) continue;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    if (step[i + j] > step[i] + 1) {
                        step[i + j] = step[i] + 1;
                    }
                }
            }
        }
        return step[nums.length - 1];
    }

    /**
     * 正向贪心
     */
    public int jump2(int[] nums) {
        int end = 0, maxDis = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 时刻更新最远可以到达的距离
            if (i + nums[i] > maxDis) {
                maxDis = i + nums[i];
            }
            // 如果当前位置是上一轮跳跃可以到达的最远处时
            if (i == end) {
                // 需要增加一次跳跃, 更新当前跳跃可以到达的最远处
                end = maxDis;
                step++;
            }
        }
        return step;
    }
}
