package com.leetcode.main.interval201.q299;

/**
 * 猜数字游戏
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-26
 */
public class Solution {
    /**
     * 统计数量
     */
    public String getHint(String secret, String guess) {
        int countA = 0, countB = 0;
        int[] secretStat = new int[10], guessStat = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if (ch1 == ch2) {
                countA++;
            } else {
                secretStat[ch1 - '0']++;
                guessStat[ch2 - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            countB += Math.min(secretStat[i], guessStat[i]);
        }
        return String.format("%dA%dB", countA, countB);
    }
}
