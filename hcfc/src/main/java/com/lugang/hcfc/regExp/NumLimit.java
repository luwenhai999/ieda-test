package com.lugang.hcfc.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符-限定符
 * 用于指定前面的字符或字符项出现多少次
 */
public class NumLimit {
    private static final String str;

    /**
     * * :出现零次或n次,无要求
     * + :出现一次或n此,至少一次
     * ? :出现零次或一次,最多一次
     * {n} :出现n次,
     * {n,} :至少出现n次, 匹配时按照最多次匹配
     * {n,m} :至少出现n次,最多出现m次,匹配时首先按照m次进行匹配
     *
     * @param args
     */
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("1*");
        Matcher matcher = compile.matcher(str);
        // 找到匹配的起始下标以及结束下表+1
        while (matcher.find()) {
            System.out.println("匹配到:" + matcher.group(0));
        }
    }

    static {
        str = "11111aaaaa";
    }
}
