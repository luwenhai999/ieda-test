package com.juzi.month202603.day20260323;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author wenhai.lu
 * Create at 2026-03-23 下午 8:13
 */
public class SortUseInsertMobile {
    private static int[] a = {2, 4, 7, 8, 1, 3, 9, 5, 10};

    public static void main(String[] args) {
        for (int i = 1; i < a.length; i++) {
            int current = a[i];
            int preIndex = i - 1;
            // 这个循环完毕后,preIndex所在的位置就是第一个小于目标值的位置,该位置并不需要动
            while (preIndex >= 0 && a[preIndex] > current) {
                a[preIndex + 1] = a[preIndex];
                preIndex--;
            }
            a[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(a));
    }
}
