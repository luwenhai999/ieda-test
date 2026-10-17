package com.lugang.hcfc.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 结巴去重
 */
public class Repetition {
    private static final String str;

    public static void main(String[] args) {
        String a = "https://www.bilibili.com:80/video/BV1Eq4y1E79W?p=26&spm_id_from=pageDriver&vd_source=93a990a8dc80f356f4ad4f75dc45385e";
        String regExp="(?<protocol>[A-Za-z]+?)://(?<domainName>[a-zA-Z.]+?):(?<port>\\d+?)(/\\w+)*/(?<fileName>[\\w.]+)(\\?.*)?";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()){
            System.out.println("protocol:"+matcher.group("protocol"));
            System.out.println("domainName:"+matcher.group("domainName"));
            System.out.println("port:"+matcher.group("port"));
            System.out.println("fileName:"+matcher.group("fileName"));
        }
    }

    static {
        str = "";
    }
}
