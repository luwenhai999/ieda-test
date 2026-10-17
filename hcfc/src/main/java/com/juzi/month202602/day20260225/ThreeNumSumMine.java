package com.juzi.month202602.day20260225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 三数之和
 *
 * @author wenhai.lu
 * Create at 2026-02-25 下午 8:34
 */
public class ThreeNumSumMine {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4, -1};
        Arrays.sort(a);
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        myTrace(result, path, a, 0);
        System.out.println(result);
        // 定义入参
        // 终止条件
        // 循环方式
        // 递归
        // 回溯
    }

    public static void myTrace(List<List<Integer>> result, Stack<Integer> path, int[] a, int index) {
        if (path.size() >= 3) {
            int num = 0;
            List<Integer> pathList = new ArrayList<>();
            for (Integer integer : path) {
                num += a[integer];
                pathList.add(a[integer]);
            }
            if (num == 0) {
                result.add(new ArrayList<>(pathList));
            }
            return;
        }
        for (int i = index; i < a.length; i++) {
            // 不能跳跃,相等的两个值,前面那个值没有被选,则后面那个值不能选
            if (i > 0
                    && a[i - 1] == a[i]
                    && !path.contains(i - 1)) {
                continue;
            }
            path.add(i);
            myTrace(result, path, a, i + 1);
            path.pop();
        }
    }
}
