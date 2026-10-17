package com.juzi.month202603.day20260307;

/**
 * @author wenhai.lu
 * Create at 2026-03-07 下午 8:21
 */
public class StringConvert {
    public static void main(String[] args) {
        String a = "lugang";
        char[] chars = a.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        String s = new String(chars);
        System.out.println(s);
    }
}
