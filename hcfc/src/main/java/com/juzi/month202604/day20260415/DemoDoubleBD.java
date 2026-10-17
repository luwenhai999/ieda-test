package com.juzi.month202604.day20260415;

import java.math.BigDecimal;

/**
 * bigDecimal和double
 *
 * @author wenhai.lu
 * Create at 2026-04-16 下午 1:25
 */
public class DemoDoubleBD {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = new BigDecimal("0.1");
        System.out.println(bigDecimal1);
        BigDecimal third = BigDecimal.valueOf(0.1);
        System.out.println(third);
    }
}
