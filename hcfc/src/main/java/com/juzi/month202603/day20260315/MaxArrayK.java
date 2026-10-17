package com.juzi.month202603.day20260315;

/**
 * 寻找数组中第k大的数字
 *
 * @author wenhai.lu
 * Create at 2026-03-15 下午 9:32
 */
public class MaxArrayK {
    public static void main(String[] args) {
        int[] a = {1, 9, 6, 2, 3, 4, 5, 7, 8};
        int target = 2;
        int index = 0;
        for (int i = 0; i < a.length - 1; i++) {
            index++;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
            if (index == target) {
                System.out.println(a[i]);
                break;
            }
        }
    }
}
