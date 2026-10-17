package com.juzi.month202604.day20260414;

import com.juzi.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的全路径,另一种隐藏回溯的方法
 *
 * @author wenhai.lu
 * Create at 2026-04-14 下午 10:52
 */
public class TreeNodeAllPathSecondDemo {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        backTrace(root, "");
        System.out.println(result);
    }

    private static void backTrace(TreeNode node, String sb) {
        if (sb.length() == 0) {
            sb += (node.value);
        } else {
            sb += ("->") + (node.value);
        }
        if (node.left == null && node.right == null) {
            result.add(sb.toString());
            return;
        }
        if (node.left != null) {
            backTrace(node.left, sb);
        }
        if (node.right != null) {
            backTrace(node.right, sb);
        }
    }
}
