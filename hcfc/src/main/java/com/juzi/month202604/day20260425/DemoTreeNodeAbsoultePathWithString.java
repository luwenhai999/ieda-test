package com.juzi.month202604.day20260425;

import com.juzi.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * @author wenhai.lu
 * Create at 2026-04-25 下午 10:10
 */
public class DemoTreeNodeAbsoultePathWithString {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        backTrace(root, null);
        System.out.println(result);
    }

    private static void backTrace(TreeNode node, String path) {
        //第一次
        if (path == null) {
            path = node.value + "";
        } else {
            // 后续添加
            path = path + "->" + node.value;
        }
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        if (node.left != null) {
            backTrace(node.left, path);
        }
        if (node.right != null) {
            backTrace(node.right, path);
        }

    }
}
