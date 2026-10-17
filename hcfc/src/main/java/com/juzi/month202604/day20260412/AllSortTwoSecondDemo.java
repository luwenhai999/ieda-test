package com.juzi.month202604.day20260412;

import java.util.*;

/**
 * 全排列2,第二种set做法
 *
 * @author wenhai.lu
 * Create at 2026-04-12 下午 9:55
 */
public class AllSortTwoSecondDemo {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        boolean[] indexFlag = new boolean[a.length];
        backTrace(a, indexFlag);
        System.out.println(result);
    }

    private static void backTrace(int[] a, boolean[] indexFlag) {
        if (path.size() >= a.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (indexFlag[i]) {
                continue;
            }
            // 树层上已经使用过该元素,则不再继续使用,继续使用就是重复值
            // 前面的值没有被使用,后面的值直接使用,会造成重复,只需要使用前面的值就行
            if (set.contains(a[i])) {
                continue;
            }
            set.add(a[i]);
            indexFlag[i] = true;
            path.add(a[i]);
            backTrace(a, indexFlag);
            path.pop();
            indexFlag[i] = false;
        }
    }
}
