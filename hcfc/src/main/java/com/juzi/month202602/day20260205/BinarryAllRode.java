package com.juzi.month202602.day20260205;

import com.juzi.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树上的所有路径
 *
 * @author wenhai.lu
 * Create at 2026-02-05 23:47
 */
public class BinarryAllRode {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6};
        TreeNode root = getNode(a, 0);
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.value);
        temp(root, result, path);
        System.out.println(result);
    }

    private static void temp(TreeNode root, List<String> result, List<Integer> path) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            path.add(root.left.value);
            temp(root.left, result, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.value);
            temp(root.right, result, path);
            path.remove(path.size() - 1);
        }
    }

    private static void getAllRode(TreeNode root, List<List<Integer>> allRode, List<Integer> rode) {
        if (root == null) {
            allRode.add(new ArrayList<>(rode));
            rode.clear();
            return;
        }
        rode.add(root.value);
    }

    private static TreeNode getNode(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = getNode(arr, index * 2 + 1);
        root.right = getNode(arr, index * 2 + 2);
        return root;
    }
}
