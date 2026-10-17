package com.juzi.month202604.day20260424;

import com.juzi.TreeNode;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * @author wenhai.lu
 * Create at 2026-04-24 下午 10:18
 */
public class TreeNodeAllPath {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        pathTreace(root, null);
        System.out.println(result);
    }

    private static void pathTreace(TreeNode node, String path) {
        if (StringUtils.isEmpty(path)) {
            path = "" + node.value;
        } else {
            path = path + "->" + node.value;
        }
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        if (node.left != null) {
            pathTreace(node.left, path);
        }
        if (node.right != null) {
            pathTreace(node.right, path);
        }
    }
}
