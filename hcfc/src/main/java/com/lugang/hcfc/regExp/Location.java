package com.lugang.hcfc.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符-定位符
 * 规定要匹配的字符串出现的位置, 比如规定起始位置或者结束位置
 */
public class Location {
    private static final String str;

    /**
     * ^ :起始位置, 所要匹配的字符串首个字符必须得符合,不会从中间截取. 只会处理打头的这片数据
     * $ :结束在字符. 结束符号可以与*混合使用,也可以与?混合使用代表结尾但是最多一个相关符号
     * \\b :匹配目标字符串的边界
     *
     * @param args
     */
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("ck\\b");
        Matcher matcher = compile.matcher(str);
        // 找到匹配的起始下标以及结束下表+1
        while (matcher.find()) {
            System.out.println("匹配到:" + matcher.group(0));
        }
    }

    static {
        str = "I am lock";
    }
}
