package com.juzi.month202603.day20260312;

/**
 * 最长无重复字符
 *
 * @author wenhai.lu
 * Create at 2026-03-12 下午 1:20
 */
public class MaxNoRepeatStr {
    public static void main(String[] args) {
        String a = "abadbbcbb";
        char[] charArray = a.toCharArray();
        System.out.println(charArray['a']);
//        HashSet<Character> set = new HashSet<>();
//        int left = 0;
//        int max = 0;
//        for (int i = 0; i < charArray.length; i++) {
//            char c = charArray[i];
//            while (set.contains(c)) {
//                set.remove(charArray[left++]);
//            }
//            set.add(c);
//            max = Math.max(max, set.size());
//        }
//        System.out.println(max);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        // 数组索引代表字符ASCII码，值代表字符最后出现的位置+1（避免初始值0的干扰）
        int[] charIndex = new int[128];

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // 若字符已出现过，更新左指针为「当前左指针」和「字符最后出现位置+1」的较大值
            left = Math.max(left, charIndex[currentChar]);
            // 记录当前字符的最新位置+1
            charIndex[currentChar] = right + 1;
            // 更新最长长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
