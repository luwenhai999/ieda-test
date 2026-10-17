package com.juzi.month202604.day20260428;

import java.util.Arrays;

/**
 * 有序数组去重
 *
 * @author wenhai.lu
 * Create at 2026-04-28 下午 10:18
 */
public class DemoSortArrayDelRepeat {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4, 5, 5};
        int repeat = repeat(a);
        System.out.println(repeat);
        System.out.println(Arrays.toString(a));
    }

    private static int repeat(int[] a) {
        int slow = 1;
        int fast = 1;
        for (; fast < a.length; fast++) {
            if (a[fast] == a[fast - 1]) {
                continue;
            }
            a[slow++] = a[fast];
        }
        return slow;
    }
}
