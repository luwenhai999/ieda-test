package com.juzi.month202603.day20260307;

/**
 * 域名反转
 *
 * @author wenhai.lu
 * Create at 2026-03-07 下午 9:39
 */
public class domainConvert {
    public static void main(String[] args) {
        String a = "www.example.com";
        String[] split = a.split("\\.");
        int start = 0;
        int end = split.length - 1;
        while (start < end) {
            String temp = split[start];
            split[start] = split[end];
            split[end] = temp;
            start++;
            end--;
        }
        String join = String.join(".", split);
        System.out.println(join);
    }
}
