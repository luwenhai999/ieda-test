package com.lugang.hcfc.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证
 */
public class TestOne {
    private static final String str;

    public static void main(String[] args) {
        String input = "12320-111222333";
//        String pattern = "^([\\u4E00-\\u9FA5]{2,}?(?:省|自治区|市|特别行政区))?(?:([\\u4E00-\\u9FA5]{2,}?(?:市|自治州|盟|地区))?(?:([\\u4E00-\\u9FA5]{2,}?(?:区|县))?)?)?.*$";
        String pattern = "(\\d)(\\d)\\d\\2\\1-(\\d)\\3{2}(\\d)\\4{2}(\\d)\\5{2}";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        if (matcher.matches()) {
            String province = matcher.group(1);
            String city = matcher.group(2);
            String county = matcher.group(3);

            System.out.println("省级行政单位：" + (province != null ? province : ""));
            System.out.println("市级行政单位：" + (city != null ? city : ""));
            System.out.println("县级行政单位：" + (county != null ? county : ""));
        } else {
            System.out.println("不匹配");
        }
    }

    static {
        str = "https://www.bilibili.com/video/BV1Eq4y1E79W/?p=17&spm_id_from=pageDriver&vd_source=93a990a8dc80f356f4ad4f75dc45385e";
//        str = "https://";
    }

}
