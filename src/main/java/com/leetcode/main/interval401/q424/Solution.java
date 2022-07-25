package com.leetcode.main.interval401.q424;

/**
 * 替换后的最长重复字符
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-25
 */
public class Solution {
    /**
     * 滑动窗口
     */
    public int characterReplacement(String s, int k) {
        // 记录当前滑动窗口内的字符数量统计表, 始终维护
        int[] map = new int[26];
        // 记录滑动窗口内最大的单字符数量
        int maxSize = 0;
        // 滑动窗口左右边界
        int left = 0, right = 0;
        while (right < s.length()) {
            // 右侧加入的字符
            int index = s.charAt(right) - 'A';
            // 统计数量
            map[index]++;
            // 更新单字符最大值
            maxSize = Math.max(maxSize, map[index]);
            if (right - left + 1 > k + maxSize) {
                // 如果k不够用了
                index = s.charAt(left) - 'A';
                map[index]--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
