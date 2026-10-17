package com.juzi.month202602.day20260203;


/**
 * 字符串反转
 *
 * @author wenhai.lu
 * Create at 2026-02-02 21:07
 */
public class StringVonert {
    public static void main(String[] args) {
        String a = "123456";
        char[] chars = a.toCharArray();
        int left = 0;
        int right = a.length() - 1;
        while (left < right) {
            char rc = chars[right];
            char lc = chars[left];
            chars[right] = lc;
            chars[left] = rc;
            right--;
            left++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            sb.append(chars[i]);
        }
        sb.reverse();
        System.out.println(sb.toString());

    }
}
