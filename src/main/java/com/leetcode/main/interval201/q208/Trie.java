package com.leetcode.main.interval201.q208;

/**
 * 实现 Trie (前缀树)
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-20
 */
public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return dfs(node);
    }

    private boolean dfs(TrieNode node) {
        if (node == null) return false;
        if (node.isEnd) return true;
        for (TrieNode childNode : node.children) {
            if (dfs(childNode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 前缀树/字典树 是一种树状数据结构, 有根节点
     * 前缀树的最大分叉数量是字符种类数
     * 包含字符种类数个子节点和当前位置是否存在某个字符串结束的布尔值
     */
    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
}
