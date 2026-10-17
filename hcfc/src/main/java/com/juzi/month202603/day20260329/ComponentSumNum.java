package com.juzi.month202603.day20260329;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合总和
 *
 * @author wenhai.lu
 * Create at 2026-03-29 下午 9:21
 */
public class ComponentSumNum {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        int target = 9;
        backTrace(n, k, target, 0, 1);
        System.out.println(result);
    }

    private static void backTrace(int n, int k, int target, int sum, int index) {
        if (path.size() >= k) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            sum += i;
            backTrace(n, k, target, sum, i + 1);
            sum -= i;
            path.pop();
        }
    }
}
