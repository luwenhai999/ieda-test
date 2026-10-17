package com.juzi.month202604.day20260426;

import com.juzi.TreeNode;

/**
 * 二叉树的最小深度
 *
 * @author wenhai.lu
 * Create at 2026-04-26 下午 6:07
 */
public class TreeNodeMinLength {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        int minLength = getMinLength(root);
        System.out.println(minLength);
    }

    private static int getMinLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 如果左为空
        if (node.left == null) {
            return getMinLength(node.right) + 1;
        }
        if (node.right == null) {
            return getMinLength(node.left) + 1;
        }
        return Math.min(getMinLength(node.left), getMinLength(node.right)) + 1;
    }
}
