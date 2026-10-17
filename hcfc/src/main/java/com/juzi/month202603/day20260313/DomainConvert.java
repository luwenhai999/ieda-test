package com.juzi.month202603.day20260313;


/**
 * 域名反转
 *
 * @author wenhai.lu
 * Create at 2026-03-13 下午 9:59
 */
public class DomainConvert {
    public static void main(String[] args) {
        String a = "http.com.baidu";
        char[] array = a.toCharArray();
        convert(array, 0, array.length - 1);
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '.') {
                convert(array, left, i - 1);
                left = i + 1;
            }
        }
        // 最后一批
        convert(array, left, array.length - 1);
        String string = new String(array);
        System.out.println(string);
    }

    /**
     * 注意是左闭右闭区间
     *
     * @param array
     * @param start
     * @param end
     */
    private static void convert(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    private static void useSimpleSplit(String a) {
        String[] split = a.split("\\.");
        for (int i = 0; i < split.length / 2; i++) {
            String temp = split[i];
            split[i] = split[split.length - i - 1];
            split[split.length - i - 1] = temp;
        }
        String join = String.join(".", split);
        System.out.println(join);
    }
}
