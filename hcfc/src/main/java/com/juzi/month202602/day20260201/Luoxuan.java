package com.juzi.month202602.day20260201;

import java.util.Arrays;

/**
 * 螺旋矩阵
 *
 * @author wenhai.lu
 * Create at 2026-02-01 22:47
 */
public class Luoxuan {
    public static void main(String[] args) {
        int n = 3;
        int c = 0;
        int index = 1;
        int[][] a = new int[n][n];
        // 共循环多少圈
        while (c < n / 2) {
            int x = c;
            int y = c;
            // 上层数据
            for (; y < n - 1 - c; y++) {
                a[x][y] = index++;
            }
            // 右侧数据
            for (; x < n - 1 - c; x++) {
                a[x][y] = index++;
            }
            // 下层数据
            for (; y > c; y--) {
                a[x][y] = index++;
            }
            // 做成数据
            for (; x > c; x--) {
                a[x][y] = index++;
            }
            c++;
        }
        if (n % 2 != 0) {
            a[n / 2][n / 2] = index;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
