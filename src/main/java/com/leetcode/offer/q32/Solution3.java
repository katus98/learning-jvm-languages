package com.leetcode.offer.q32;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-13
 */
public class Solution3 {

    /**
     * 使用两个堆栈进行操作, 保证每一行都用一个新堆栈, 每一层的放入顺序交替变化 (原创略麻烦)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int level = 0;
        Deque<TreeNode> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            level++;
            List<Integer> levelList = new ArrayList<>();
            if (level % 2 == 1) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    levelList.add(node.val);
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    levelList.add(node.val);
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
            }
            list.add(levelList);
        }
        return list;
    }

    /**
     * 非常巧妙的方法, 遍历顺序和放入顺序可以相反, 只要偶数层反着加入列表即可
     * 另辟蹊径: 直接将上一题结果中的偶数层翻转即可
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.remove();
                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
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
