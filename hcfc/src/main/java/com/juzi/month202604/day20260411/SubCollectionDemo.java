package com.juzi.month202604.day20260411;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 子集问题
 *
 * @author wenhai.lu
 * Create at 2026-04-11 下午 10:03
 */
public class SubCollectionDemo {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        backTrace(a, 0);
        System.out.println(result);
    }

    private static void backTrace(int[] a, int startIndex) {
        if (path.size() > 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < a.length; i++) {
            path.add(a[i]);
            backTrace(a, i + 1);
            path.pop();
        }

    }


}
