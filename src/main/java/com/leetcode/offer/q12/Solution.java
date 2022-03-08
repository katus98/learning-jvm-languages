package com.leetcode.offer.q12;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * DFS + 剪枝
 *
 * @author SUN Katus
 * @version 1.0, 2022-03-08
 */
public class Solution {
    private final Set<String> set = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) {
            return true;
        }
        int m = board.length, n = m > 0 ? board[0].length : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.clear();
                if (dfs(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word) {
        if (word.isEmpty()) {
            return true;
        }
        int m = board.length, n = m > 0 ? board[0].length : 0;
        if (checkValid(i, j, m, n)) {
            if (board[i][j] == word.charAt(0)) {
                set.add(i + "-" + j);
                String nWord = word.substring(1);
                if (dfs(board, i + 1, j, nWord)
                        || dfs(board, i - 1, j, nWord)
                        || dfs(board, i, j + 1, nWord)
                        || dfs(board, i, j - 1, nWord)) {
                    return true;
                } else {
                    // 如果当前路径搜索不到, 请务必记住将已经访问过的标记去除
                    set.remove(i + "-" + j);
                }
            }
        }
        return false;
    }

    private boolean checkValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n && !set.contains(i + "-" + j);
    }

    /**
     * 其他人的dfs参考, 更加简洁
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    @Test
    public void test() {
        System.out.println(exist(new char[][]{{'a', 'b'}, {'d', 'c'}}, "abcd"));
        System.out.println(exist(new char[][]{{'a'}}, "a"));
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }
}
