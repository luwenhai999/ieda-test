package com.juzi.month202603.day20260331;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author wenhai.lu
 * Create at 2026-03-31 下午 1:28
 */
public class ComponentRepeatNumSum {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();


    public static void main(String[] args) {
        int[] a = {2,5,2,1,2};
        boolean[] pathFlag = new boolean[a.length];
        Arrays.sort(a);
        int target = 5;
        backTrace(a, pathFlag, target, 0, 0);
        System.out.println(result);
    }

    private static void backTrace(int[] a, boolean[] pathFlag, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < a.length; i++) {
            // 去重,如果同一个元素,他的前一个没有被使用,则它不能被单独使用
            if (i > 0 && a[i] == a[i - 1] && !pathFlag[i - 1]) {
                continue;
            }
            pathFlag[i] = true;
            path.add(a[i]);
            backTrace(a, pathFlag, target, sum + a[i], i + 1);
            path.pop();
            pathFlag[i] = false;
        }
    }
}
