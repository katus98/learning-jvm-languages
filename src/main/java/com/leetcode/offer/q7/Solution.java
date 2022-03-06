package com.leetcode.offer.q7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-06
 */
public class Solution {

    /**
     * 自己编写的递归方法, 缺点是每次递归都要复制数组, 过于占用空间
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root;
        if (preorder.length > 0) {
            root = new TreeNode(preorder[0]);
            int index;
            for (index = 0; index < inorder.length; index++) {
                if (inorder[index] == preorder[0]) {
                    break;
                }
            }
            int[] lPre = new int[index], lIn = new int[index];
            int[] rPre = new int[preorder.length - index - 1], rIn = new int[preorder.length - index - 1];
            for (int i = 0; i < index; i++) {
                lPre[i] = preorder[i + 1];
                lIn[i] = inorder[i];
            }
            root.left = buildTree(lPre, lIn);
            for (int i = 0; i < preorder.length - index - 1; i++) {
                rPre[i] = preorder[index + i + 1];
                rIn[i] = inorder[index + i + 1];
            }
            root.right = buildTree(rPre, rIn);
        } else {
            root = null;
        }
        return root;
    }

    /**
     * 构建中序遍历的简易查找表
     */
    private Map<Integer, Integer> map;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 通过传入首尾索引号来避免复制内容, 但是有些难以理解, 尤其是索引计算
     */
    private TreeNode buildSubTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        TreeNode root;
        if (preRight < preLeft) {
            root = null;
        } else {
            root = new TreeNode(preorder[preLeft]);
            int index = map.get(root.val);
            int leftSize = index - inLeft, rightSize = preRight - preLeft - leftSize;
            root.left = buildSubTree(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inLeft + leftSize - 1);
            root.right = buildSubTree(preorder, inorder, preLeft + leftSize + 1, preRight, inLeft + leftSize + 1, inRight);
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
