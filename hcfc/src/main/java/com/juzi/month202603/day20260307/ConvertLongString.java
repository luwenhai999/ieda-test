package com.juzi.month202603.day20260307;

/**
 * @author wenhai.lu
 * Create at 2026-03-07 下午 9:13
 */
public class ConvertLongString {
    public static void main(String[] args) {
        String a = "  hello  world!  ";
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = a.length() - 1;
        while (a.charAt(start) == ' ') {
            start++;
        }
        while (a.charAt(end) == ' ') {
            end--;
        }
        while (start <= end) {
            if (a.charAt(start) == ' ' && a.charAt(start - 1) == ' ') {
                start++;
                continue;
            }
            sb.append(a.charAt(start));
            start++;
        }
        System.out.println(sb);
        System.out.println(sb.length());
        char[] chars = sb.toString().toCharArray();
        convert(chars, 0, chars.length - 1);
        int thisStart = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int thisEnd = i - 1;
                convert(chars, thisStart, thisEnd);
                thisStart = i + 1;
            }
            if (i == chars.length - 1) {
                int thisEnd = i;
                convert(chars, thisStart, thisEnd);
                thisStart = i + 1;
            }
        }
        System.out.println(new String(chars));
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
