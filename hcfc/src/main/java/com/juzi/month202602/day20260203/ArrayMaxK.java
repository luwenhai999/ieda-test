package com.juzi.month202602.day20260203;

import java.util.Arrays;

/**
 * @author wenhai.lu
 * Create at 2026-02-03 20:14
 */
public class ArrayMaxK {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int target = 2;
        int c = 0;
        for (int i = 0; i < a.length - 1; i++) {
            c++;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
            if (c == target) {
                System.out.println(a[i]);
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main1(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int target = 2;
        int k = 0;
        for (int i = 0; i < a.length - 1; i++) {
            k++;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            if (k == target) {
                System.out.println(a[i]);
                break;
            }
        }
    }
}
