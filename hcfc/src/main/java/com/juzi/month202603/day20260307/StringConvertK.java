package com.juzi.month202603.day20260307;


/**
 * 前k个字符串的反转
 *
 * @author wenhai.lu
 * Create at 2026-03-07 下午 8:37
 */
public class StringConvertK {
    public static void main(String[] args) {
        String a = "abcdefg";
        char[] array = a.toCharArray();
        int k = 2;
        for (int i = 0; i < array.length; i += 2 * k) {
            int start = i;
            int next = i + 2 * k;
            // 如果end<array.length
            // 此处有临界点,是i->end,or, i->i+k
            if (next < array.length) {
                int end = Math.min(array.length - 1, i + k - 1);
                convert(array, i, end);
            } else {
                convert(array, i, i + k - 1);
            }
        }
        System.out.println(new String(array));
    }

    private static void convert(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
