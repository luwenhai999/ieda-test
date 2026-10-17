package com.juzi.month202604.day20260415;

import com.juzi.TreeNode;

import java.util.*;

/**
 * 二叉树的便利
 *
 * @author wenhai.lu
 * Create at 2026-04-15 下午 9:10
 */
public class DemoTreeNodeFor {
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int thisLevelSize = queue.size();
            List<Integer> thisLevelList = new ArrayList<>(thisLevelSize);
            while (thisLevelSize > 0) {
                TreeNode thisNode = queue.poll();
                thisLevelList.add(thisNode.value);
                if (thisNode.left != null) {
                    queue.add(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.add(thisNode.right);
                }
                thisLevelSize--;
            }
            result.add(thisLevelList);
        }
        System.out.println(result);
    }

    private static void testMid(TreeNode root) {
        // 中序遍历(3140526)
        TreeNode cur = root;
        Stack<TreeNode> path = new Stack<>();
        while (cur != null || !path.isEmpty()) {
            if (cur != null) {
                path.add(cur);
                cur = cur.left;
                continue;
            }
            TreeNode thisNode = path.pop();
            System.out.print(thisNode.value);
            cur = thisNode.right;
        }
    }

    private static void testRight(TreeNode root) {
        // 右序遍历(3415620)
        // 中->左->右;返回来就是
        String a = "";
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode thisNode = stack.pop();
            a = thisNode.value + a;
            if (thisNode.left != null) {
                stack.add(thisNode.left);
            }
            if (thisNode.right != null) {
                stack.add(thisNode.right);
            }
        }
        System.out.println(a);
    }

    private static void testLeft(TreeNode root) {
        // 左序遍历(0134256)
        // 中左右=>中->右->左
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode thisNode = stack.pop();
            System.out.print(thisNode.value);
            if (thisNode.right != null) {
                stack.add(thisNode.right);
            }
            if (thisNode.left != null) {
                stack.add(thisNode.left);
            }
        }
    }


    /**
     * 左序遍历(0134256)
     *
     * @param node
     */
    private static void printLeft(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        printLeft(node.left);
        printLeft(node.right);
    }

    /**
     * 中序遍历(3140526)
     *
     * @param node
     */
    private static void printMid(TreeNode node) {
        if (node == null) {
            return;
        }
        printMid(node.left);
        System.out.print(node.value);
        printMid(node.right);
    }

    /**
     * 后序遍历(3415620)
     *
     * @param node
     */
    private static void printRight(TreeNode node) {
        if (node == null) {
            return;
        }
        printRight(node.left);
        printRight(node.right);
        System.out.print(node.value);
    }
}
