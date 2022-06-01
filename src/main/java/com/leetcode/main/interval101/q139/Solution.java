package com.leetcode.main.interval101.q139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-01
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return canGenerate(new StringBuilder(), s, wordDict);
    }

    /**
     * 通过单词集合组装长字符串, 通过dfs回溯方法, 事实证明超时
     */
    private boolean canGenerate(StringBuilder builder, String s, List<String> wordDict) {
        if (builder.length() == s.length()) {
            return true;
        }
        for (String word : wordDict) {
            builder.append(word);
            if (s.startsWith(builder.toString())) {
                boolean res = canGenerate(builder, s, wordDict);
                if (res) {
                    return true;
                }
            }
            builder.delete(builder.length() - word.length(), builder.length());
        }
        return false;
    }

    /**
     * DP
     * 前i个字符串是否可以被单词集合中的单词组成
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
