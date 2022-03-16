package com.leetcode.main.q297;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 * @see com.leetcode.offer.q37.Codec
 */
public class Codec {
    /**
     * 反序遍历解法
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 切记需要倒叙来确定根节点
     */
    public TreeNode deserialize(String data) {
        LinkedList<Integer> queue = new LinkedList<>();
        String[] valStr = data.split(",");
        for (String valS : valStr) {
            if ("null".equals(valS)) {
                queue.addFirst(null);
            } else {
                queue.addFirst(Integer.valueOf(valS));
            }
        }
        return revPostOrder(queue);
    }

    private void postOrder(TreeNode root, StringBuilder builder) {
        if (root != null) {
            postOrder(root.left, builder);
            postOrder(root.right, builder);
            builder.append(root.val).append(",");
        } else {
            builder.append("null,");
        }
    }

    private TreeNode revPostOrder(Queue<Integer> queue) {
        if (queue.peek() == null) {
            queue.remove();
            return null;
        }
        TreeNode root = new TreeNode(queue.remove());
        root.right = revPostOrder(queue);
        root.left = revPostOrder(queue);
        return root;
    }

    @Test
    public void test() {
        deserialize("null,null,2,null,null,4,null,null,5,3,1");
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
