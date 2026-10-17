package com.juzi.month202604.day20260412;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 全排列
 *
 * @author wenhai.lu
 * Create at 2026-04-12 下午 9:41
 */
public class AllSort {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        boolean[] indexFlag = new boolean[a.length];
        backTrace(a, indexFlag);
        System.out.println(result);
    }

    private static void backTrace(int[] a, boolean[] indexFlag) {
        if (path.size() >= a.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (indexFlag[i]) {
                continue;
            }
            indexFlag[i] = true;
            path.add(a[i]);
            backTrace(a, indexFlag);
            path.pop();
            indexFlag[i] = false;
        }
    }
}
