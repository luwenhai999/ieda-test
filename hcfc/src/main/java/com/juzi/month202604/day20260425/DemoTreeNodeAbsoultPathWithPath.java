package com.juzi.month202604.day20260425;

import com.juzi.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的全路径
 *
 * @author wenhai.lu
 * Create at 2026-04-25 下午 9:47
 */
public class DemoTreeNodeAbsoultPathWithPath {
    private static List<String> result = new ArrayList<>();
    private static Stack<TreeNode> path = new Stack<>();

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        path.add(treeNode);
        trace(treeNode);
        System.out.println(result);
    }

    private static void trace(TreeNode node) {
        if (node.left == null && node.right == null) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>(path);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < treeNodes.size() - 1; i++) {
                sb.append(treeNodes.get(i).value).append("->");
            }
            sb.append(treeNodes.get(treeNodes.size() - 1).value);
            result.add(sb.toString());
            return;
        }
        if (node.left != null) {
            path.add(node.left);
            trace(node.left);
            path.pop();
        }
        if (node.right != null) {
            path.add(node.right);
            trace(node.right);
            path.pop();
        }
    }

}
