package com.lugang.hcfc.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符-字符匹配符
 */
public class SingleMatch {
    private static final String str;

    /**
     * [abv] :任意一个
     * [^agb] :只要不是这个就行
     * . :代表任意的字符
     * + :至少一个
     * ? :最多一个
     * * :个数不限
     * (?i) :不区分大小写
     * \\d :数字
     * \\D :非数字
     * \\w: 任意字母数字下划线 0-9a-zA-Z_
     * \\W :非字母
     *
     * @param args
     */
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("(?i)[a-z]");
        Matcher matcher = compile.matcher(str);
        while ((matcher.find())) {
            System.out.println("匹配的值:" + matcher.group(0));
        }
    }

    static {
        str = "a11.bAb";
    }
}
