package com.juzi.month202604.day20260411;

import java.util.*;

/**
 * 子集二问题
 *
 * @author wenhai.lu
 * Create at 2026-04-11 下午 10:37
 */
public class SubCollectionTwoDemo {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        backTrace(a, 0);
        System.out.println(result);
    }

    private static void backTrace(int[] a, int startIndex) {
        result.add(new ArrayList<>(path));
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < a.length; i++) {
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
