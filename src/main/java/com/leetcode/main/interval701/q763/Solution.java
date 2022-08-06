package com.leetcode.main.interval701.q763;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 划分字母区间
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-06
 */
public class Solution {
    /**
     * 统计词频
     */
    public List<Integer> partitionLabels(String s) {
        int[] allStat = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            allStat[ch - 'a']++;
        }
        int[] stat = new int[26];
        List<Integer> resList = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            stat[ch - 'a']++;
            set.add(ch);
            if (check(allStat, stat, set)) {
                set.clear();
                resList.add(i - last);
                last = i;
            }
        }
        return resList;
    }

    /**
     * 贪心
     */
    public List<Integer> partitionLabels2(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    private boolean check(int[] allStat, int[] stat, Set<Character> set) {
        for (char c : set) {
            if (stat[c - 'a'] != allStat[c - 'a']) return false;
        }
        return true;
    }
}
