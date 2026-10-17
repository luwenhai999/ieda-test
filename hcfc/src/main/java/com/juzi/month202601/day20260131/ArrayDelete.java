package com.juzi.month202601.day20260131;

/**
 * 删除数组中的一个元素
 *
 * @author wenhai.lu
 * Create at 2026-01-31 18:14
 */
public class ArrayDelete {
    public static void main(String[] args) {
        // 双指针
        int[] a = {0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;
        int slow = 0;
        int fast = 0;
        while (fast < a.length) {
            if (a[fast] != target) {
                a[slow++] = a[fast];
            }
            fast++;
        }
        System.out.println(slow);
    }

    private static void useForce() {
        // 暴力破解
        int[] a = {0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;
        int num = a.length;
        for (int i = 0; i < num; i++) {
            if (a[i] == target) {
                for (int j = i; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                num--;
                i--;
            }
        }
        System.out.println(num);
    }
}
