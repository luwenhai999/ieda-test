package com.juzi.month202602.day20260203;

/**
 * 单词纬度的反转
 *
 * @author wenhai.lu
 * Create at 2026-02-03 18:30
 */
public class StringConvertWord {
    public static void main(String[] args) {
        String a = "the sky is blue";
        // 上一个字符不是空格
        boolean lastNotWhite = true;
        StringBuilder sb = new StringBuilder();
        // 整体反转
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {
                // 如果是空格,且第一次出现
                if (lastNotWhite) {
                    sb.append(a.charAt(i));
                    lastNotWhite = false;
                } else {
                    // 如果是空格,非第一次,不再处理
                }
                continue;
            }
            // 如果遇到非空格
            sb.append(a.charAt(i));
            lastNotWhite = true;
        }
        System.out.println(sb);
        System.out.println(sb.toString().length());
        // 针对单词反转
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            char lc = sb.charAt(left);
            char rc = sb.charAt(right);
            sb.setCharAt(left, rc);
            sb.setCharAt(right, lc);
            left++;
            right--;
        }
        System.out.println(sb);
        // 再次反转具体的单词
        int first = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                left = first;
                right = i - 1;
                while (left < right) {
                    char lc = sb.charAt(left);
                    char rc = sb.charAt(right);
                    sb.setCharAt(left, rc);
                    sb.setCharAt(right, lc);
                    left++;
                    right--;
                }
                first = i + 1;
            }
        }
        left = first;
        right = sb.length() - 1;
        while (left < right) {
            char lc = sb.charAt(left);
            char rc = sb.charAt(right);
            sb.setCharAt(left, rc);
            sb.setCharAt(right, lc);
            left++;
            right--;
        }
        System.out.println(sb);
    }

}
