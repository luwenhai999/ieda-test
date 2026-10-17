package com.juzi.month202604.day20260413;

import com.juzi.TreeNode;

import java.util.Stack;

/**
 * 使用栈的方式遍历
 *
 * @author wenhai.lu
 * Create at 2026-04-13 下午 2:18
 */
public class TreeNodeForUseStack {
    public static void main(String[] args) {
        // 中序遍历(3140526)
        TreeNode root = TreeNode.getTreeNode();
        Stack<TreeNode> path = new Stack<>();
        TreeNode cur = root;
        while (cur != null
                || !path.isEmpty()) {
            if (cur != null) {
                path.add(cur);
                cur = cur.left;
            } else {
                TreeNode pop = path.pop();
                System.out.print(pop.value);
                cur = pop.right;
            }
        }
    }

    public static void postFor(String[] args) {
        // 前序遍历(0134256)
        TreeNode root = TreeNode.getTreeNode();
        Stack<TreeNode> path = new Stack<>();
        path.add(root);
        while (!path.isEmpty()) {
            TreeNode thisOne = path.pop();
            System.out.print(thisOne.value);
            if (thisOne.right != null) {
                path.add(thisOne.right);
            }
            if (thisOne.left != null) {
                path.add(thisOne.left);
            }
        }
    }
}
