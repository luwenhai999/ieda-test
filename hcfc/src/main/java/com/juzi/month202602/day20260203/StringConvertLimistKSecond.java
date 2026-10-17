package com.juzi.month202602.day20260203;

/**
 * 前k个字符反转,第二种方式
 *
 * @author wenhai.lu
 * Create at 2026-02-03 17:52
 */
public class StringConvertLimistKSecond {
    public static void main(String[] args) {
        String a = "abcdefg";
        StringBuilder sb = new StringBuilder();
        int k = 2;
        for (int i = 0; i < a.length(); i += 2 * k) {
            // 小于k
            if (a.length() <= i + k) {
                String substring = a.substring(i);
                sb.append(new StringBuffer(substring).reverse());
            } else if (a.length() <= i + 2 * k) {
                // 在k和2k之间
                sb.append(new StringBuffer(a.substring(i, i + k)).reverse());
                sb.append(a.substring(i + k));
            } else {
                // 超过2k
                sb.append(new StringBuffer(a.substring(i, i + k)).reverse());
                sb.append(a.substring(i + k, i + 2 * k));
            }
        }
        System.out.println(sb);
    }
}
