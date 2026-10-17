package com.juzi.month202603.day20260329;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合问题
 *
 * @author wenhai.lu
 * Create at 2026-03-29 下午 3:22
 */
public class ComponentDemo {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        backTraceing(result, path, n, k, 1);
        System.out.println(result);
    }

    private static void backTraceing(List<List<Integer>> result, Stack<Integer> path, int n, int k, int index) {
        if (path.size() >= k) {
            result.add(new ArrayList<>(path));
            return;

        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            backTraceing(result, path, n, k, i + 1);
            path.pop();
        }

    }
}
