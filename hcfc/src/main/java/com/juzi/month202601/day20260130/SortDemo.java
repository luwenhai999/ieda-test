package com.juzi.month202601.day20260130;

import java.util.Arrays;

/**
 * 排序实验
 * 1. 冒泡排序
 * 2. 归并排序
 * 3. 选择排序
 * 4. 插入排序
 * 5. 快速排序
 * 可参考: https://cloud.tencent.com/developer/article/1767908
 *
 * @author wenhai.lu
 * Create at 2026-01-30 15:23
 */
public class SortDemo {
    private static int[] a = {2, 4, 7, 8, 1, 3, 9, 5, 10};

    public static void main(String[] args) {
        // 快速排序
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 快速排序,需要指定数组,以及起止下标
     * 1. 如果只有一个待计算元素的时候,停止
     * 2. 找到切分点
     * 3. 对左右分别进行快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 找到基准
        int povit = findPovit(arr, left, right);
        quickSort(arr, 0, povit - 1);
        quickSort(arr, povit + 1, right);

    }

    /**
     * 找到最右边值该待的位置
     * 1. 基准坐标,默认在最前面
     * 2. 如果出现一个数字i,小于基准值,则基准坐标加一,此时这个值就是该值的真实下标
     * 3. 然后将i处的数据替换到真实下标处
     * 4. 真是下表都是小于基准值的,真是下标+1就是基准值该待的位置
     * 5. 将基准值该待的位置与最后边的数据进行交换
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int findPovit(int[] arr, int left, int right) {
        // slow表示的是小于基准值的真是下标,
        // 如果没有小于基准值的,则是left-1,无效的数据
        // slow最终还会加一,此时会将基准值放到这里
        int slow = left - 1;
        int midValue = arr[right];

        // 最后一个值为基准值,所以不在使用它
        for (int fast = left; fast < right; fast++) {
            if (arr[fast] < midValue) {
                // 代表已经确定的小于基准值,它所对应的下标
                slow++;
                int temp = a[slow];
                a[slow] = a[fast];
                a[fast] = temp;
            }
        }

        slow++;
        int temp = a[slow];
        a[slow] = midValue;
        a[right] = temp;
        return slow;
    }

    private static void useInsert() {
        // 插入排序
        for (int i = 1; i < a.length; i++) {
            int current = a[i];
            int preIndex = i - 1;
            // 前一个的位置
            // current相当于就是当前位置
            while (preIndex >= 0 && current < a[preIndex]) {
                // 将前一个的位置数据后移,将比目标值大的数据向后移动,直到留出一个空位
                a[preIndex + 1] = a[preIndex];
                preIndex--;
            }
            // preIndex是前一个的位置, 则加一就是当前它该待的位置
            a[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(a));
    }

    private static void useSelect() {
        // 选择排序
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    private static void useMerge() {
        int[] first = {1, 3, 5, 7, 9};
        int[] second = {2, 4, 6, 8};
        int firstIndex = 0;
        int secondIndex = 0;
        int[] temp = new int[first.length + second.length];
        int tempIndex = 0;
        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] <= second[secondIndex]) {
                temp[tempIndex++] = first[firstIndex++];
            } else {
                temp[tempIndex++] = second[secondIndex++];
            }
        }
        while (firstIndex < first.length) {
            temp[tempIndex++] = first[firstIndex++];
        }
        while (secondIndex < second.length) {
            temp[tempIndex++] = second[secondIndex++];
        }
        System.out.println(Arrays.toString(temp));
    }


    private static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int left = 0;
        int right = arr.length;
        int mid = left + (right + left) / 2;
        int[] first = Arrays.copyOfRange(arr, left, mid);
        int[] second = Arrays.copyOfRange(arr, mid, arr.length);
    }


//    private static void mergeSort(int[] source, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mid = (right - left) / 2 + left;
//        mergeSort(source, left, mid);
//        mergeSort(source, mid + 1, right);
//        merge(source, left, mid, right);
//    }
//
//    private static void merge(int[] source, int left, int mid, int right) {
//        int[] temp = new int[right - left + 1];
//        int i = 0;
//        int first = left;
//        int second = mid + 1;
//        while (first <= mid && second <= right) {
//            if (source[first] <= source[second]) {
//                temp[i++] = source[first++];
//            } else {
//                temp[i++] = source[second++];
//            }
//        }
//        while (first <= mid) {
//            temp[i++] = source[first++];
//        }
//        while (second <= right) {
//            temp[i++] = source[second++];
//        }
//        for (int index = left; index <= right; index++) {
//            source[index] = temp[index - left];
//        }
//    }


    private static void userBubbleSort() {
        // 冒泡排序
        // 最多对比n-1次
        for (int i = 0; i < a.length - 1; i++) {
            // 两两对比时,j不能到达边界,所以是小于;
            // 同时由于会用到j+1,所以要减1
            // 上一次已经达到的边界,本次就不需要了,所以每次的边界都会小1,所以减i
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
