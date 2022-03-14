package com.leetcode.offer.q33;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-13
 */
public class Solution {
    /**
     * 分治法递归, 会超时
     * 思路: 最后一个元素必定是根节点, 从前到后扫描第一个大于根节点的元素开始是右子树, 保证左子树都小于根节点, 右子树都大于
     */
    public boolean verifyPostorder(int[] postorder) {
        return verifySearchTree(postorder, 0, postorder.length - 1);
    }

    private boolean verifySearchTree(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int root = postorder[j];
        int k;
        for (k = i; k < j; k++) {
            if (postorder[k] > root) {
                break;
            }
        }
        for (int l = k + 1; l < j; l++) {
            if (postorder[l] <= root) {
                return false;
            }
        }
        return verifySearchTree(postorder, 0, k - 1) && verifySearchTree(postorder, k, j - 1);
    }

    /**
     * 模拟构建BST, 如果恰好可以利用上全部的元素即正确
     * 此题理解较困难
     */
    private int end;   // 判断是否完全遍历

    public boolean verifyPostorder2(int[] postorder) {
        if (postorder == null || postorder.length <= 2) return true;
        end = postorder.length - 1;
        build(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return end < 0;   // 如果完全遍历，则end < 0;
    }

    private void build(int[] postorder, int min, int max) {
        if (end < 0) return;   // 空了，返回
        int rootV = postorder[end];
        if (rootV >= max || rootV <= min) return;
        end--;
        build(postorder, rootV, max);   // 右子树
        build(postorder, min, rootV);   // 左子树
    }
}
