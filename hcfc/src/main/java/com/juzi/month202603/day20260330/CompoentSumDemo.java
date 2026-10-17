package com.juzi.month202603.day20260330;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合总和
 *
 * @author wenhai.lu
 * Create at 2026-03-30 下午 3:12
 */
public class CompoentSumDemo {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        int k = 7;
        backTrace(a, k, 0, 0);
        System.out.println(result);

    }

    private static void backTrace(int[] a, int k, int sum, int index) {
        if (sum == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > k) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            path.add(a[i]);
            backTrace(a, k, sum + a[i], i);
            path.pop();
        }

    }
}
