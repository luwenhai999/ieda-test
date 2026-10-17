package com.juzi.month202602.day20260205;

import com.juzi.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组转成list
 *
 * @author wenhai.lu
 * Create at 2026-02-05 23:10
 */
public class ArrayToNodeList {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6};
        TreeNode root = getNode(a, 0);
        // 前序遍历,中左右
        // 中序遍历,左中右
        List<Integer> result = new ArrayList<>();
        print(root, result);
        System.out.println(result);
    }

    private static void print(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        print(root.left, result);
        result.add(root.value);
        print(root.right, result);
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
