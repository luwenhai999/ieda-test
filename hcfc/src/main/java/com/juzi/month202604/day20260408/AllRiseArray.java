package com.juzi.month202604.day20260408;

import java.util.*;

/**
 * 递增子序列
 *
 * @author wenhai.lu
 * Create at 2026-04-08 下午 9:14
 */
public class AllRiseArray {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        int[] a = {4, 6, 7, 7};
        backTrace(a, 0);
        System.out.println(result);
    }

    private static void backTrace(int[] a, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < a.length; i++) {
            if (!path.isEmpty() && path.peek() > a[i]) {
                continue;
            }
            if (set.contains(a[i])) {
                continue;
            }
            set.add(a[i]);
            path.add(a[i]);
            backTrace(a, i + 1);
            path.pop();
        }
    }
}
