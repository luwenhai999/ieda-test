package com.lugang.hcfc.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符-分组
 */
public class Group {
    private static final String str;

    /**
     * (pattern) :分组
     * (?<name>pattern) :命名分组
     * (?:pattern) :非捕获分组,可以匹配到,但是不能用group(1)获取到数据. 如果不带?:则可以通过group(1)获取到部分数据
     * (?=pattern) :非捕获分组,只要能匹配上括号里内容的前半截
     * (?!pattern) :上面的取反,只要不能匹配括号里内容的前半截
     *
     * @param args
     */
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("luwenhai(?!Student)");
        Matcher matcher = compile.matcher(str);
        // 找到匹配的起始下标以及结束下表+1
        while (matcher.find()) {
            System.out.println("匹配到:" + matcher.group());
//            System.out.println("匹配到:" + matcher.group(1));
        }
    }

    static {
        str = "luwenhaiEnginer,luwenhaiStudent,luwenhaiStudent";
    }
}
