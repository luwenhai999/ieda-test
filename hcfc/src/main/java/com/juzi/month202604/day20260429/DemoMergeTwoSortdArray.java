package com.juzi.month202604.day20260429;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author wenhai.lu
 * Create at 2026-04-29 下午 2:11
 */
public class DemoMergeTwoSortdArray {
    public static void main(String[] args) {
        int[] first = {2, 4, 6, 8, 10};
        int[] second = {1, 3, 5, 7, 9};
        int[] target = new int[first.length + second.length];
        int index = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] < second[secondIndex]) {
                target[index++] = first[firstIndex++];
            } else {
                target[index++] = second[secondIndex++];
            }
        }
        while (firstIndex < first.length) {
            target[index++] = first[firstIndex++];
        }

        while (secondIndex < second.length) {
            target[index++] = second[secondIndex++];
        }
        System.out.println(Arrays.toString(target));
    }
}
