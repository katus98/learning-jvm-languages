package com.leetcode.main.interval1.q55;

/**
 * 跳跃游戏
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-28
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // 记录当前能够到达的最大下标
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前下标不能到达则退出
            if (i > maxIndex) break;
            // 判断当前位置所能到的最远位置是否可以刷新记录
            if (nums[i] + i > maxIndex) {
                maxIndex = nums[i] + i;
            }
        }
        return maxIndex >= nums.length - 1;
    }
}
