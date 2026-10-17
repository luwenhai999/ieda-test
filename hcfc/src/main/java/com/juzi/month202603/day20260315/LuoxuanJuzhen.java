package com.juzi.month202603.day20260315;

import java.util.Arrays;

/**
 * 螺旋矩阵
 *
 * @author wenhai.lu
 * Create at 2026-03-15 下午 1:50
 */
public class LuoxuanJuzhen {

    public static void main(String[] args) {
        int target = 4;
        int c = 0;
        // 123
        // 894
        // 765
        int index = 1;
        int[][] a = new int[target][target];

        // 循环的总圈数
        while (c < target / 2) {
            int x = c;
            int y = c;
            // 上面的行,x不变,y递增
            for (; y < target - 1 - c; y++) {
                a[x][y] = index++;
            }
            // 右边的行,y不变,x递增
            for (; x < target - 1 - c; x++) {
                a[x][y] = index++;
            }
            // 下面的行,x不变,y递减
            for (; y > c; y--) {
                a[x][y] = index++;
            }
            // 左面的行,y不变,x递减
            for (; x > c; x--) {
                a[x][y] = index++;
            }
            // c表示已经执行了几圈,从零开始
            c++;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
