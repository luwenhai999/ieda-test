package com.juzi.month202603.day20260310;

/**
 * 重复的子字符串
 *
 * @author wenhai.lu
 * Create at 2026-03-10 下午 7:34
 */
public class StringRepeat {
    public static void main(String[] args) {
        String a = "abab";
        boolean flag = false;
        first:
        for (int i = 1; i <= a.length() / 2; i++) {
            int length = i - 0;
            if (a.length() % length != 0) {
                continue;
            }
            String base = a.substring(0, i);
            second:
            for (int j = i; j <= a.length() - i; j += i) {
                String thisStr = a.substring(j, j + i);
                if (!thisStr.equals(base)) {
                    continue first;
                }
            }
            flag = true;
            System.out.println(a.substring(0, i));
            break first;
        }
        System.out.println(flag);
    }
}
