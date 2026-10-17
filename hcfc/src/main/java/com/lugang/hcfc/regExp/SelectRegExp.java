package com.lugang.hcfc.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择匹配符
 */
public class SelectRegExp {
    private static final String str;

    public static void main(String[] args) {
        Pattern compile = Pattern.compile("lugang|wenhai");
        Matcher matcher = compile.matcher(str);
        // 找到匹配的起始下标以及结束下表+1
        while (matcher.find()) {
            System.out.println("匹配到:" + matcher.group(0));
        }
    }

    static {
        str = "lugang and wenhai both are my name";
    }

}
