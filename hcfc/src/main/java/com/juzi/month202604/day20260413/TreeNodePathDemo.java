package com.juzi.month202604.day20260413;

import com.juzi.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的所有路径
 *
 * @author wenhai.lu
 * Create at 2026-04-13 下午 10:49
 */
public class TreeNodePathDemo {

    private static List<String> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();

    }

    private static void print(TreeNode root) {
        if (root == null) {
            ArrayList<Integer> integers = new ArrayList<>(path);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < integers.size(); i++) {
                sb.append(integers.get(i)).append("->");
            }
            sb.append(integers.get(integers.size() - 1));
            return;
        }
        path.add(root.value);
        print(root.left);
        print(root.right);

    }
}
