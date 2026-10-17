package com.juzi.month202602.day20260205;

/**
 * 最长重复子数组
 *
 * @author wenhai.lu
 * Create at 2026-02-05 17:05
 */
public class MaxRepeatArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 1, 4, 7};
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}
