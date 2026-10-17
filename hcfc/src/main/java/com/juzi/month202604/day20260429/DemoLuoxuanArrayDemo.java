package com.juzi.month202604.day20260429;

import java.util.Arrays;

/**
 * 螺旋矩阵
 *
 * @author wenhai.lu
 * Create at 2026-04-29 下午 2:00
 */
public class DemoLuoxuanArrayDemo {

    public static void main(String[] args) {
        int target = 4;
        int c = 0;
        int index = 1;
        int[][] a = new int[target][target];
        while (c < target / 2) {
            int x = c;
            int y = c;
            for (; y < target - 1 - c; y++) {
                a[x][y] = index++;
            }
            for (; x < target - 1 - c; x++) {
                a[x][y] = index++;
            }
            for (; y > c; y--) {
                a[x][y] = index++;
            }
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
