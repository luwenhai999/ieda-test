package com.juzi.month202603.day20260323;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 自己处理输入
 * 2. 归并排序
 *
 * @author wenhai.lu
 * Create at 2026-03-24 上午 12:20
 */
public class SortScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = scanner.nextInt();
        }
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        quickSort(a, left, mid);
        quickSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (a[leftIndex] < a[rightIndex]) {
                temp[index++] = a[leftIndex++];
            } else {
                temp[index++] = a[rightIndex++];
            }
        }
        while (rightIndex <= right) {
            temp[index++] = a[rightIndex++];
        }
        while (leftIndex <= mid) {
            temp[index++] = a[leftIndex++];
        }

        for (int i = 0; i < temp.length; i++) {
            a[i + left] = temp[i];
        }
    }
}
