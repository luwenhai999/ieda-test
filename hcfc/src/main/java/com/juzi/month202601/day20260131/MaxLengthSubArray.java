package com.juzi.month202601.day20260131;

/**
 * 长度最小的子数组
 * 1. 暴力
 * 2. 非暴力
 * 3. dp
 *
 * @author wenhai.lu
 * Create at 2026-01-31 18:52
 */
public class MaxLengthSubArray {
    public static void main(String[] args) {
        // 滑动窗口
        int[] a = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < a.length; right++) {
            sum += a[right];
            while (sum >= target) {
                // 这是一个左闭右闭的区间
                min = Math.min(min, right - left + 1);
                // 如果超过了的话,则会将left右移,同时会将该数据减掉,left的值本身是在区间内的
                sum -= a[left++];
            }
        }
        System.out.println(min);
    }

    private static void useForce() {
        int[] a = {2, 3, 1, 2, 4, 2};
        int target = 7;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int j = i;
            int total = 0;
            while (j < a.length) {
                total += a[j];
                if (total == target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
                j++;
            }
        }
        System.out.println(min);
    }
}
