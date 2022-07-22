package com.leetcode.main.interval701.q735;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 行星碰撞
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-22
 */
public class Solution {
    /**
     * 堆栈从左侧开始记录当前没有碰撞的星星
     * 仅对向左飞的星星进行判断碰撞
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        // 从左向右遍历
        for (int asteroid : asteroids) {
            // 标记当前星星是否存在
            boolean alive = true;
            // 只有当前星星向左飞 堆顶元素向右飞 才需要判断碰撞
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                // 判断当前行星是否存活
                alive = stack.peek() < -asteroid;
                if (stack.peek() <= -asteroid) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            // 存活的话加入堆栈
            if (alive) {
                stack.push(asteroid);
            }
        }
        int i = stack.size() - 1;
        int[] res = new int[stack.size()];
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}
