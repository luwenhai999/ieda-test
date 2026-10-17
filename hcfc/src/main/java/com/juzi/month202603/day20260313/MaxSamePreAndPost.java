package com.juzi.month202603.day20260313;

import java.util.Arrays;

/**
 * 最长公共前后缀
 *
 * @author wenhai.lu
 * Create at 2026-03-13 下午 10:13
 */
public class MaxSamePreAndPost {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight", "haode"};
        String str = getStr(strs);
        System.out.println(str);
        System.out.println(str.length());
    }

    private static String getStr(String[] strs) {
        if (strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        // 拿出第一个
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            // 顺序拿出字符
            char thisChar = first.charAt(i);
            // 后续数组中的其他字符串同一个位置的字符,于第一个的字符对比,有一个不一样,则代表i这个位置不匹配
            // 需要截取到i的前一个为止
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != thisChar) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    private static void failDemo() {
        String str = "aabaaf";
        int[] next = new int[str.length()];
        // 总计数也是从1开始,只有到1时才会有数据
        // 截止数据为length,相等,即闭最后一位的index大1,因为此方法为左闭右开方法
        for (int i = 1; i <= str.length(); i++) {
            next[i - 1] = getNum(str.substring(0, i));
        }
        System.out.println(Arrays.toString(next));
    }

    private static int getNum(String a) {
        int max = 0;
        // i从1开始,因为只有右侧是1时才会有数据
        // i<length,这个时候最大值是length-1,即尾号的位置,而此方法为左闭右开区间,所以最后一位不计入
        for (int i = 1; i < a.length(); i++) {
            String pre = a.substring(0, i);
            String post = a.substring(a.length() - i);
            if (pre.equals(post)) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}
