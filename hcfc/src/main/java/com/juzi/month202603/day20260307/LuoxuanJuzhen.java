package com.juzi.month202603.day20260307;

import java.util.Arrays;

/**
 * 螺旋矩阵
 *
 * @author wenhai.lu
 * Create at 2026-03-07 下午 10:24
 */
public class LuoxuanJuzhen {
    /**
     * 123
     * 894
     * 765
     */
    public static void main(String[] args) {
        int target = 4;
        int c = 0;
        int index = 1;
        int[][] a = new int[target][target];
        // 共多少圈
        while (c < target / 2) {
            // 第c圈
            int x = c;
            int y = c;
            // 上一行,x不变,y递增
            for (; y < target - 1 - c; y++) {
                a[x][y] = index++;
            }
            // 右一行,y不变,x递增
            for (; x < target - 1 - c; x++) {
                a[x][y] = index++;
            }
            // 下一行,x不变,y递减
            for (; y > c; y--) {
                a[x][y] = index++;
            }
            // 左一行,y不变,x递减
            for (; x > c; x--) {
                a[x][y] = index++;
            }
            c++;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
