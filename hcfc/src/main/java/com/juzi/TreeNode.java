package com.juzi;

/**
 * @author wenhai.lu
 * Create at 2026-02-05 22:32
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public static TreeNode getTreeNode() {
        int[] a = {0, 1, 2, 3, 4};
        return getNode(a, 0);
    }

    private static TreeNode getNode(int[] a, int startInderx) {
        if (startInderx >= a.length) {
            return null;
        }
        TreeNode root = new TreeNode(a[startInderx]);
        root.left = getNode(a, startInderx * 2 + 1);
        root.right = getNode(a, startInderx * 2 + 2);
        return root;
    }
}
