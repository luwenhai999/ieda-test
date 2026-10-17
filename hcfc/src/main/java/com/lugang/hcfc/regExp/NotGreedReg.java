package com.lugang.hcfc.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 非贪婪匹配
 */
public class NotGreedReg {
    private static final String str;

    /**
     * ? :跟在限定符号 + * ? {n} {n,m}之后标识非贪婪算法,只匹配最少的字符数量
     *
     * @param args
     */
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("\\d+?");
        Matcher matcher = compile.matcher(str);
        // 找到匹配的起始下标以及结束下标+1
        while (matcher.find()) {
            System.out.println("匹配到:" + matcher.group());
        }
    }

    static {
        str = "111111abcd";
    }
}
