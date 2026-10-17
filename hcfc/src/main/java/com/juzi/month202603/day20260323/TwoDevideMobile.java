package com.juzi.month202603.day20260323;

/**
 * 二分查找
 * 前提是数组是有序的
 *
 * @author wenhai.lu
 * Create at 2026-03-23 下午 7:53
 */
public class TwoDevideMobile {
    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int target = -1;
        int left = 0;
        int right = a.length - 1;
        boolean flag = false;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                index = mid;
                flag = true;
                break;
            }
            if (a[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(index);
    }
}
