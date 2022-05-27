package com.leetcode.main.interval401.q470;

/**
 * 用 Rand7() 实现 Rand10()
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-07
 */
public class Solution extends SolBase {
    /**
     * 生成两位数, 分别生成个位和十位, 然后分析各种情况的概率
     */
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    /**
     * 混沌暴力, 反复调用随机求和然后对范围取余, 理论上调用次数越多, 越随机
     */
    public int rand10_2() {
        return (rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7() + rand7()) % 10 + 1;
    }
}
