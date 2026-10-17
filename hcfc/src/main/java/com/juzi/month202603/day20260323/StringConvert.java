package com.juzi.month202603.day20260323;

import java.util.Arrays;
import java.util.List;

/**
 * 原因字母反转
 *
 * @author wenhai.lu
 * Create at 2026-03-23 下午 11:32
 */
public class StringConvert {
    public static void main(String[] args) {
        String a = "hello";
        char[] chars = a.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u');
        while (left < right) {
            while (left < right && !characters.contains(chars[left])) {
                left++;
            }
            while (left < right && !characters.contains(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        System.out.println(new String(chars));
    }
}
