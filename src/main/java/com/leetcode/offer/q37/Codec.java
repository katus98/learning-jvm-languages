package com.leetcode.offer.q37;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-16
 */
public class Codec {
    /**
     * 原创解法, 与题目描述完全一致, 但是会超出内存限制;
     * 层序遍历, 保证遍历的是完整的平衡二叉树
     */
    public String serialize(TreeNode root) {
        if (root == null) return "x";
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1, start = 0, end = (1 << level) - 1;
        boolean flag = true;
        while (!queue.isEmpty()) {
            if (flag) {
                flag = false;
                for (int i = start; i < end; i++) {
                    TreeNode node = queue.remove();
                    if (node != null) {
                        list.add(node.val);
                        queue.add(node.left);
                        queue.add(node.right);
                        if (!flag) {
                            flag = node.left != null || node.right != null;
                        }
                    } else {
                        list.add(null);
                        queue.add(null);
                        queue.add(null);
                    }
                }
            } else {
                break;
            }
            level++;
            start = end;
            end = (1 << level) - 1;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer val : list) {
            if (val == null) {
                sb.append("x,");
            } else {
                sb.append(val).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] valStr = data.split(",");
        TreeNode[] nodes = new TreeNode[valStr.length];
        for (int i = 0; i < valStr.length; i++) {
            String valS = valStr[i];
            if (valS.equals("x")) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.parseInt(valS));
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            int childIndex = (i + 1) * 2 - 1;
            if (childIndex >= nodes.length) {
                break;
            }
            if (nodes[i] != null) {
                nodes[i].left = nodes[childIndex];
                nodes[i].right = nodes[childIndex + 1];
            }
        }
        return nodes[0];
    }

    /**
     * 层序遍历, 但是会输出所有的非空节点及其子节点
     */
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 仍然是依靠队列辅助, 每次弹出一个元素, 向数组后找两个放到子结点上, 然后子节点入队
     */
    public TreeNode deserialize2(String data) {
        List<TreeNode> nodeList = Arrays
                .stream(data.split(","))
                .map(str -> "null".equals(str) ? null : new TreeNode(Integer.parseInt(str)))
                .collect(Collectors.toList());
        int i = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(nodeList.get(i++));
        while (i < nodeList.size()) {
            TreeNode node = queue.remove();
            if (node != null) {
                node.left = nodeList.get(i++);
                node.right = nodeList.get(i++);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return nodeList.get(0);
    }

    /**
     * 前序遍历, 但是会输出所有的非空节点及其子节点
     */
    public String serialize3(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 反向前序遍历
     */
    public TreeNode deserialize3(String data) {
        Queue<Integer> queue = new LinkedList<>();
        String[] valStr = data.split(",");
        for (String valS : valStr) {
            if ("null".equals(valS)) {
                queue.add(null);
            } else {
                queue.add(Integer.valueOf(valS));
            }
        }
        return revPreOrder(queue);
    }

    private void preOrder(TreeNode root, StringBuilder builder) {
        if (root != null) {
            builder.append(root.val).append(",");
            preOrder(root.left, builder);
            preOrder(root.right, builder);
        } else {
            builder.append("null,");
        }
    }

    private TreeNode revPreOrder(Queue<Integer> queue) {
        if (queue.peek() == null) {
            queue.remove();
            return null;
        }
        TreeNode root = new TreeNode(queue.remove());
        root.left = revPreOrder(queue);
        root.right = revPreOrder(queue);
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
