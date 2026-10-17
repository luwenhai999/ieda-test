package com.juzi.month202603.day20260314;

import java.util.Arrays;

/**
 * 有序数组去重
 *
 * @author wenhai.lu
 * Create at 2026-03-14 下午 2:57
 */
public class SortArrayDistinct {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 3, 4, 5, 5};
        int slow = 0;
        for (int i = 1; i < a.length; i++) {
            // 这样的话,slow就是左边无重复区间的有值了,左闭右闭
            if (a[i] == a[slow]) {
                continue;
            }
            // 如果是这样的话,slow已经不代表无重复的区间有值了,而是右边那个值
            // 上面的a[i]与a[slow]的比较,就不是最后一个值的了,
            slow++;
            // 此时的slow让是左闭右闭
            a[slow] = a[i];
        }
        System.out.println(slow + 1);
        System.out.println(Arrays.toString(a));
    }

    public static void main2(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 3, 4, 5, 5};
        removeDuplicates(a);
        System.out.println(Arrays.toString(a));
    }

    public static int removeDuplicates(int[] nums) {
        // 边界条件：空数组或只有1个元素，直接返回长度
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        // 慢指针：初始指向第一个元素
        int slow = 0;
        // 快指针：遍历数组
        for (int fast = 1; fast < nums.length; fast++) {
            // 找到不重复的元素
            if (nums[fast] != nums[slow]) {
                slow++; // 慢指针右移
                nums[slow] = nums[fast]; // 赋值，覆盖重复位置
            }
            // 重复则快指针继续走，慢指针不动
        }

        // 慢指针+1 是去重后数组长度
        return slow + 1;
    }
}
