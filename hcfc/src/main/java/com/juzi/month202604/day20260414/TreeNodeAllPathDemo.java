package com.juzi.month202604.day20260414;

import com.juzi.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 记录二叉树的所有路径
 *
 * @author wenhai.lu
 * Create at 2026-04-14 下午 9:42
 */
public class TreeNodeAllPathDemo {
    private static List<String> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        backTrace(root);
        System.out.println(result);
    }

    private static void backTrace(TreeNode node) {
        path.add(node.value);
        if (node.left == null && node.right == null) {
            ArrayList<Integer> integers = new ArrayList<>(path);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < integers.size() - 1; i++) {
                sb.append(integers.get(i)).append("->");
            }
            sb.append(integers.get(integers.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (node.left != null) {
            // backTrace方法返回的条件就是入参的数据变成空了
            // 然后回退回来后,这个node就是它的上一级节点了其实
            // 回退回来,证明这个node的子节点都被处理了
            // 如果这个方法回去相当于回到了这个节点的父节点
            // 
            backTrace(node.left);
            path.pop();
        }
        if (node.right != null) {
            backTrace(node.right);
            path.pop();
        }
    }

}
