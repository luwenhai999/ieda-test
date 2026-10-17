package com.juzi.month202603.day20260308;

/**
 * 获取最大的第k个数据
 *
 * @author wenhai.lu
 * Create at 2026-03-08 下午 1:27
 */
public class MaxK {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int k = 2;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            if (i == k - 1) {
                System.out.println(a[i]);
                break;
            }
        }
    }
}

