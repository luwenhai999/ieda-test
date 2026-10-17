package com.juzi.month202601.day20260131;

/**
 * 二分查找
 *
 * @author wenhai.lu
 * Create at 2026-01-31 17:47
 */
public class TwoDevide {
    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int left = 0;
        int right = a.length - 1;
        boolean find = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                System.out.println(mid);
                find = true;
                break;
            }
            if (a[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (!find) {
            System.out.println(-1);
        }
    }
}
