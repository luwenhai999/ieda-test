package com.juzi.month202603.day20260310;

import java.util.Arrays;

/**
 * kmp的暴力解法
 *
 * @author wenhai.lu
 * Create at 2026-03-10 下午 7:08
 */
public class KMPForce {
    public static void main(String[] args) {
        String str = "aabaaf";
        int[] next = new int[str.length()];
        for (int i = 1; i <= str.length(); i++) {
            int num = getNum(str.substring(0, i));
            next[i - 1] = num;
        }
        System.out.println(Arrays.toString(next));

    }

    private static int getNum(String a) {
        int max = 0;
        for (int i = 1; i < a.length(); i++) {
            String pre = a.substring(0, i);
            String post = a.substring(a.length() - i);
            if (pre.equals(post)) {
                max = Math.max(max, pre.length());
            }
        }
        return max;
    }
}
