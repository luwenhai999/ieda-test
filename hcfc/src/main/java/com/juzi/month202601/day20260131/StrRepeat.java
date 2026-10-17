package com.juzi.month202601.day20260131;

/**
 * 字符串是重复的
 *
 * @author wenhai.lu
 * Create at 2026-01-31 14:49
 */
public class StrRepeat {
    public static void main(String[] args) {
        String a = "abababab";
        boolean flag = false;
        for (int i = 1; i < a.length() / 2; i++) {
            // 如果长度不凑整,肯定不是
            if (a.length() % (i + 1) != 0) {
                continue;
            }

            // 后续待比较的部分,要轮番于目前已定位到的i做对比
            boolean thisInterupt = true;
            for (int j = i + 1; j < a.length(); j++) {
                if (a.charAt(j) != a.charAt((j - i - 1) % (i + 1))) {
                    thisInterupt = false;
                    break;
                }
            }
            if (thisInterupt) {
                flag = true;
            }
        }
        System.out.println(flag);
    }
}
