package com.leetcode.main.q47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 */
public class Solution {
    private final List<List<Integer>> list = new ArrayList<>();
    private int[] nums;
    private boolean[] visited;
    private int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.n = nums.length;
        this.visited = new boolean[n];
        Arrays.sort(nums);
        this.nums = nums;
        arrange(0, new ArrayList<>());
        return list;
    }

    /**
     * 递归函数
     * @param i 当前需要处理第几位字符
     * @param l 当前组合
     */
    private void arrange(int i, List<Integer> l) {
        // 如果当前已经到最后一位了, 说明当前是一个有效的排列
        if (i == n) {
            list.add(new ArrayList<>(l));
            return;
        }
        // 从原数组中选一个放到下一个位置上
        for (int j = 0; j < n; j++) {
            // 不能选已经选过的, 而且重复的字符必须从左到右选
            if (visited[j] || (j > 0 && nums[j] == nums[j - 1] && !visited[j - 1])) {
                continue;
            }
            // 用了某数字需要做标记
            l.add(nums[j]);
            visited[j] = true;
            // 去选填下一个位置
            arrange(i + 1, l);
            // 撤销对当前数字的使用
            visited[j] = false;
            l.remove(i);
        }
    }
}
