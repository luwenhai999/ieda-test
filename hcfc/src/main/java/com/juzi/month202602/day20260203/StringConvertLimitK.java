package com.juzi.month202602.day20260203;

/**
 * 前k个字符反转
 *
 * @author wenhai.lu
 * Create at 2026-02-03 17:37
 */
public class StringConvertLimitK {
    public static void main(String[] args) {
        String a = "abcdefg";
        int k = 2;
        int count = 0;
        StringBuilder toConvert = new StringBuilder();
        StringBuilder last = new StringBuilder();
        StringBuilder total = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            count++;
            //计数,前k个位一组
            if (count <= k) {
                toConvert.append(a.charAt(i));
            } else {
                // 后k个位一组
                last.append(a.charAt(i));
            }
            // 够一组后进行处理
            if (count == 2 * k) {
                count = 0;
                total = total.append(toConvert.reverse()).append(last);
                toConvert = new StringBuilder();
                last = new StringBuilder();
            }
        }
        total = total.append(toConvert.reverse()).append(last);
        System.out.println(total.toString());
    }
}
