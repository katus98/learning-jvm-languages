package com.leetcode.main.interval101.q114;

/**
 * 二叉树展开为链表
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-02
 */
public class Solution {
    private TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }

    /**
     * 注意到前序遍历访问各节点的顺序是根节点、左子树、右子树。
     * 如果一个节点的左子节点为空，则该节点不需要进行展开操作。
     * 如果一个节点的左子节点不为空，则该节点的左子树中的最后一个节点被访问之后，该节点的右子节点被访问。
     * 该节点的左子树中最后一个被访问的节点是左子树中的最右边的节点，也是该节点的前驱节点。
     * 因此，问题转化成寻找当前节点的前驱节点。
     *
     * 具体做法是，对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，
     * 将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋给当前节点的右子节点，
     * 并将当前节点的左子节点设为空。对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。
     */
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
