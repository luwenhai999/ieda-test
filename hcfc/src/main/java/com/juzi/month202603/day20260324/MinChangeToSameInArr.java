package com.juzi.month202603.day20260324;

import java.util.Scanner;

/**
 * 数组变动
 *
 * @author wenhai.lu
 * Create at 2026-03-24 下午 5:18
 */
public class MinChangeToSameInArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = scanner.nextInt();
        }
        int midIndex = length / 2;
        int mid = a[midIndex];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            max += Math.abs(a[i] - mid);
        }
        System.out.println(max);
    }
}
