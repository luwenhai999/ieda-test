package com.juzi.month202604.day20260413;

import com.juzi.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序遍历
 *
 * @author wenhai.lu
 * Create at 2026-04-13 下午 9:39
 */
public class TreeNodeFloorFor {
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            // 单层处理
            int thisLevelSize = queue.size();
            List<Integer> thisLevelList = new ArrayList<>(thisLevelSize);
            // 取出该层的数据,放入该层list
            // 同时将该层的下级节点都放入
            // 这个while循环完毕后,里面就只有下一级的节点了
            while (thisLevelSize > 0) {
                TreeNode treeNode = queue.pollLast();
                thisLevelList.add(treeNode.value);
                if (treeNode.left != null) {
                    queue.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addFirst(treeNode.right);
                }
                thisLevelSize--;
            }
            result.add(thisLevelList);

        }
        System.out.println(result);

    }

    public static void test(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode thisNode = queue.pollLast();
            System.out.println(thisNode.value);
            if (thisNode.left != null) {
                queue.addFirst(thisNode.left);
            }
            if (thisNode.right != null) {
                queue.addFirst(thisNode.right);
            }
        }
    }
}
