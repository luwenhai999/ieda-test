package com.juzi.month202602.day20260204;

/**
 * 买卖股票最佳时机
 *
 * @author wenhai.lu
 * Create at 2026-02-04 12:03
 */
public class GupiaoSumTanxin {
    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] > 0) {
                count += a[i] - a[i - 1];
            }
        }
        System.out.println(count);
    }
}
