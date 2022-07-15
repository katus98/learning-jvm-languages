package com.leetcode.exam.autumn.pre.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * 组成单词的数量
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-15
 */
public class Task1 {
    public int solution(String S) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('B', 0);
        map.put('A', 0);
        map.put('L', 0);
        map.put('O', 0);
        map.put('N', 0);
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res, map.get('B'));
        res = Math.min(res, map.get('A'));
        res = Math.min(res, map.get('L') / 2);
        res = Math.min(res, map.get('O') / 2);
        res = Math.min(res, map.get('N'));
        return res;
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println(task1.solution("BAONXXOLL"));
        System.out.println(task1.solution("BAOOLLNNOLOLGBAX"));
        System.out.println(task1.solution("QAWABAWONL"));
        System.out.println(task1.solution("ONLABLABLOON"));
        System.out.println(task1.solution("BA"));
        System.out.println(task1.solution("HELLO"));
        System.out.println(task1.solution(""));
        System.out.println(task1.solution("123456BALLONOBALLOONNNLLLLL"));
    }
}
