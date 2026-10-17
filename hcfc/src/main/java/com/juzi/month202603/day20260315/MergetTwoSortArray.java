package com.juzi.month202603.day20260315;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author wenhai.lu
 * Create at 2026-03-15 下午 9:18
 */
public class MergetTwoSortArray {
    public static void main(String[] args) {
        int[] first = {2, 4, 6, 8, 10};
        int[] second = {1, 3, 5, 7, 9};
        int[] temp = new int[first.length + second.length];
        int index = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] < second[secondIndex]) {
                temp[index++] = first[firstIndex++];
            } else {
                temp[index++] = second[secondIndex++];
            }
        }
        while (firstIndex < first.length) {
            temp[index++] = first[firstIndex++];
        }
        while (secondIndex < second.length) {
            temp[index++] = second[secondIndex++];
        }
        System.out.println(Arrays.toString(temp));
    }
}
