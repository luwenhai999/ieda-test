package com.juzi.month202602.day20260225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和,双指针法
 *
 * @author wenhai.lu
 * Create at 2026-02-25 下午 9:45
 */
public class ThreeNumSumDoublePoint {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4, -1};
        Arrays.sort(a);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            int left = i + 1;
            int right = a.length - 1;
            if (a[i] > 0) {
                break;
            }
            if (i > 0 && a[i - 1] == a[i]) {
                continue;
            }
            while (left < right) {
                int num = a[i] + a[left] + a[right];
                if (num == 0) {
                    result.add(Arrays.asList(a[i], a[left], a[right]));
                    while (left < right && a[left] == a[left + 1]) {
                        left++;
                    }
                    while (left < right && a[right] == a[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }
                if (num > 0) {
                    right--;
                }
                if (num < 0) {
                    left++;
                }
            }
        }
        System.out.println(result);
    }
}
