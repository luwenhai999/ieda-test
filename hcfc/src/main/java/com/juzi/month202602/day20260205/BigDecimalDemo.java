package com.juzi.month202602.day20260205;

import java.math.BigDecimal;

/**
 * @author wenhai.lu
 * Create at 2026-02-05 19:30
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal one = new BigDecimal("1");
        BigDecimal one1 = new BigDecimal("1.00");
        System.out.println(one.equals(one1));
        System.out.println(one.compareTo(one1));

    }
}
