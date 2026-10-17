package com.juzi.month202603.day20260329;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 手机键盘的组合
 *
 * @author wenhai.lu
 * Create at 2026-03-29 下午 10:01
 */
public class ComponentPhoneKeyDemo {
    private static String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static List<String> result = new ArrayList<>();
    private static Stack<Character> path = new Stack<>();

    public static void main(String[] args) {
        String target = "23";
        backTrace(target, 0, "");
        System.out.println(result);
    }


    private static void backTrace(String inputStr, int inputSort, String pathStr) {
        if (pathStr.length() == inputStr.length()) {
            result.add(pathStr);
            return;
        }
        // inputSort当前输入的第几个字符
        // 获取该层级字符对一个的数字
        int i1 = inputStr.charAt(inputSort) - '0';
        // 获取该数数字对应的真实字符串
        String str = numString[i1];

        for (int i = 0; i < str.length(); i++) {
            pathStr += str.charAt(i);
            backTrace(inputStr, inputSort + 1, pathStr);
            pathStr = pathStr.substring(0, pathStr.length() - 1);
        }

    }
}
