package com.juzi.month202604.day20260415;

import com.juzi.TreeNode;

/**
 * 二叉树的最大高度
 *
 * @author wenhai.lu
 * Create at 2026-04-15 下午 9:56
 */
public class DemoTreeNodeMaxHeigh {
    private static int max = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        backTrace(root, 1);
        System.out.println(max);
    }

    private static void backTrace(TreeNode node, int height) {
        if (node.left == null && node.right == null) {
            max = Math.min(max, height);
            return;
        }
        if (node.left != null) {
            backTrace(node.left, height + 1);
        }
        if (node.right != null) {
            backTrace(node.right, height + 1);
        }
    }
}
