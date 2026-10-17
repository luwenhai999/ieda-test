package com.juzi.month202604.day20260411;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 子集二问题,通过userd数组来解决
 *
 * @author wenhai.lu
 * Create at 2026-04-11 下午 11:02
 */
public class SubCollectionTwoSecondDemo {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> path = new Stack<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        Arrays.sort(a);
        boolean[] indexFlag = new boolean[a.length];
        backTrace(a, indexFlag, 0);
        System.out.println(result);
    }

    private static void backTrace(int[] a, boolean[] indexFlag, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < a.length; i++) {
            // 两个连续的数字,如果跳过第一个,直接选第二个,则不可
            // 因为第一个已经被选过,此时再选第二个就是相同的效果
            if (i > 0 && a[i - 1] == a[i] && !indexFlag[i - 1]) {
                continue;
            }
            path.add(a[i]);
            indexFlag[i] = true;
            backTrace(a, indexFlag, i + 1);
            indexFlag[i] = false;
            path.pop();
        }

    }
}
