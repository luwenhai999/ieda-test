package com.juzi.month202603.day20260322;

import org.springframework.boot.SpringBootVersion;

import java.util.Arrays;

/**
 * 排序算法
 * 1. 快速排序
 * 2. 归并排序
 * 3. 冒泡排序
 *
 * @author wenhai.lu
 * Create at 2026-03-22 下午 12:50
 */
public class DongfangSortDemo {
    private static int[] a = {2, 6, 4, 7, 8, 1, 3, 9, 5, 10};

    public static void main(String[] args) {
        String version = SpringBootVersion.getVersion();
        System.out.println(version);
        userMerge(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 归并算法,合并算法
     * 1. 数据切分
     * 2. 递归,其实最终是将数据切成1份
     * 3. 合并,相当于是两个数组
     *
     * @param array
     * @param left
     * @param right
     */
    private static void userMerge(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        userMerge(array, left, mid);
        userMerge(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] < array[rightIndex]) {
                temp[index++] = array[leftIndex++];
            } else {
                temp[index++] = array[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[index++] = array[leftIndex++];
        }

        while (rightIndex <= right) {
            temp[index++] = array[rightIndex++];
        }

        for (int i = left; i <= right; i++) {
            array[i] = temp[i - left];
        }

    }

    // 冒泡排序
    private static void bubule() {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private static void quick() {
        // 快速排序
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 快速排序
     * 1. 先找中间位置,此时左侧都是小于中间位置的,右侧都是大于中间位置的
     * 2. 然后再递归左侧,递归右侧
     * <p>
     * 归并排序是先递归,只到数据都变成1时在合并,此时有序的,然后再继续向上进行合并有序的
     * 快速排序是先找到中间位置,然后继续递归切分
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = getMid(array, left, right);
        quickSort(array, left, mid - 1);
        quickSort(array, mid + 1, right);
    }

    private static int getMid(int[] array, int left, int right) {
        int slow = left - 1;
        int targetValue = array[right];
        for (int fast = left; fast < right; fast++) {
            if (a[fast] < targetValue) {
                // slow++后表示这个位置还没处理,需要暂放比目标值小的数
                // 这个位置可能相等,也可能比目标值大
                slow++;
                int temp = a[fast];
                a[fast] = a[slow];
                a[slow] = temp;
            }
        }

        slow++;
        a[right] = a[slow];
        a[slow] = targetValue;
        return slow;
    }
}
