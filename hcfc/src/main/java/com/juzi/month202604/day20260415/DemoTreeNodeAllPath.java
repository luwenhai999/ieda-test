package com.juzi.month202604.day20260415;

import com.juzi.TreeNode;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有路径
 *
 * @author wenhai.lu
 * Create at 2026-04-15 下午 9:47
 */
public class DemoTreeNodeAllPath {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        backTreace(root, "");
        System.out.println(result);
    }

    private static void backTreace(TreeNode root, String path) {
        if (StringUtils.isEmpty(path)) {
            path = "" + root.value;
        } else {
            path = path + "->" + root.value;
        }
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
            backTreace(root.left, path);
        }
        if (root.right != null) {
            backTreace(root.right, path);
        }
    }

}
