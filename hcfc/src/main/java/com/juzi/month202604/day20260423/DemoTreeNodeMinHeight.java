package com.juzi.month202604.day20260423;

import com.juzi.TreeNode;

/**
 * 最小深度
 *
 * @author wenhai.lu
 * Create at 2026-04-23 下午 8:46
 */
public class DemoTreeNodeMinHeight {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        System.out.println(minHeight(treeNode));
    }

    private static int minHeight(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        // 左为空,右不为空
        if (node.left == null && node.right != null) {
            return minHeight(node.right) + 1;
        }
        // 右为空,左不为空
        if (node.right == null && node.left != null) {
            return minHeight(node.left) + 1;
        }
        // 左右都不为空
        int leftMin = minHeight(node.left);
        int rightMin = minHeight(node.right);
        return Math.min(leftMin, rightMin) + 1;
    }
}
