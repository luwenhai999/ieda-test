package com.lugang.hcfc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/lugang")
public class LugangController {

    private static final String str;

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    static {
        str = "abc(a.gag";
    }

}
