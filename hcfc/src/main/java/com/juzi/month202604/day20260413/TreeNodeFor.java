package com.juzi.month202604.day20260413;

import com.juzi.TreeNode;

/**
 * 二叉树遍历
 *
 * @author wenhai.lu
 * Create at 2026-04-13 下午 1:48
 */
public class TreeNodeFor {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        print(root);
    }

    private static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.value);
        print(root.right);
    }
}
