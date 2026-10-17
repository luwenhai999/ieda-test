package com.juzi.month202602.day20260201;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 *
 * @author wenhai.lu
 * Create at 2026-02-01 18:20
 */
public class Compose {


    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backTracing(result, path, 4, 2, 1);
        System.out.println(result);
    }

    public static void backTracing(List<List<Integer>> result, LinkedList<Integer> path, int n, int k, int start) {
        if (path.size() >= k) {
            result.add(new ArrayList<>(path));
//            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backTracing(result, path, n, k, i + 1);
            path.removeLast();
        }
    }
}
