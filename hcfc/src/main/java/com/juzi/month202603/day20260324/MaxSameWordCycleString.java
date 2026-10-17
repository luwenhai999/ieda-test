package com.juzi.month202603.day20260324;

import java.util.Scanner;

/**
 * 环形string,最长相同字符长度
 *
 * @author wenhai.lu
 * Create at 2026-03-24 下午 4:38
 */
public class MaxSameWordCycleString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s.length());
        String t = s + s;
        int max = 1;
        int current = 1;
        for (int i = 1; i < t.length(); i++) {
            if (t.charAt(i - 1) == t.charAt(i)) {
                current++;
                max = Math.max(max, current);
            } else {
                current = 1;
            }
            if (current >= s.length()) {
                break;
            }
        }
        System.out.println(max);

    }
}
