package com.juzi.month202604.day20260425;

import com.juzi.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @author wenhai.lu
 * Create at 2026-04-25 下午 9:40
 */
public class TreeNodeMaxHeight {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        int height = getHeight(treeNode);
        System.out.println(height);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int thisNodeLeftHeight = getHeight(node.left);
        int thisNodeRightHeight = getHeight(node.right);
        return Math.max(thisNodeLeftHeight, thisNodeRightHeight) + 1;
    }
}
