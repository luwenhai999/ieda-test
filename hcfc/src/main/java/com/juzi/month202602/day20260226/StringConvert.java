package com.juzi.month202602.day20260226;


/**
 * 反转字符串
 *
 * @author wenhai.lu
 * Create at 2026-02-26 下午 5:32
 */
public class StringConvert {
    public static void main(String[] args) {
        userCharArray();
    }

    private static void userCharArray() {
        String a = "hello";
        char[] chars = a.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char charJ = chars[j];
            chars[j] = chars[i];
            chars[i] = charJ;
        }
        System.out.println(new String(chars));
    }

    private static void useStringBuilder() {
        String a = "hello";
        StringBuilder sb = new StringBuilder(a);
        for (int i = 0, j = sb.length() - 1; i < sb.length() / 2; i++, j--) {
            char charJ = sb.charAt(j);
            sb.setCharAt(j, sb.charAt(i));
            sb.setCharAt(i, charJ);
        }
        System.out.println(sb);
    }
}
