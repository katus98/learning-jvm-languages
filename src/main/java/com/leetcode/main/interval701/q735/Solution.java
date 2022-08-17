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

    public int[] asteroidCollision2(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        boolean exist;
        // 从左向右遍历
        for (int asteroid : asteroids) {
            exist = true;
            // 只有右边向左运动的行星才有可能碰撞
            if (asteroid < 0) {
                // 如果前一个行星是向右移动的
                while (!deque.isEmpty() && deque.peekLast() > 0) {
                    if (deque.peekLast() > -asteroid) {
                        // 如果向右的大于向左的 则新加入的爆炸不存在了
                        exist = false;
                        break;
                    } else if (deque.peekLast() == -asteroid) {
                        // 如果向右的等于向左的 则两者都爆炸不存在了
                        exist = false;
                        deque.pollLast();
                        break;
                    } else {
                        // 如果向右的小于向左的 则向左的爆炸不存在了
                        // 继续循环
                        deque.pollLast();
                    }
                }
            }
            if (exist) {
                deque.addLast(asteroid);
            }
        }
        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.pollFirst();
        }
        return res;
    }
}
