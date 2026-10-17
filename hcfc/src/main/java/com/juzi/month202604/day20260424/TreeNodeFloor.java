package com.juzi.month202604.day20260424;

import com.juzi.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * @author wenhai.lu
 * Create at 2026-04-24 下午 10:10
 */
public class TreeNodeFloor {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Queue<TreeNode> path = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        path.add(root);
        while (!path.isEmpty()) {
            int thisLevelSize = path.size();
            List<Integer> thisLevelResult = new ArrayList<>();
            while (thisLevelSize > 0) {
                TreeNode poll = path.poll();
                thisLevelResult.add(poll.value);
                if (poll.left != null) {
                    path.add(poll.left);
                }
                if (poll.right != null) {
                    path.add(poll.right);
                }
                thisLevelSize--;
            }
            result.add(thisLevelResult);
        }
        System.out.print(result);
    }

}
