package com.leetcode.competition.weekly.w300;

import java.util.HashMap;
import java.util.Map;

/**
 * 解密消息
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-03
 */
public class Solution6180 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char a = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (Character.isLetter(ch) && !map.containsKey(ch)) {
                map.put(ch, a);
                a++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                builder.append(map.get(ch));
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution6180 solution6180 = new Solution6180();
        System.out.println(solution6180.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(solution6180.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
