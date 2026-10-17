package com.lugang.demo;

/**
 * 测试一些算法
 *
 * @author wenhai.lu
 * Create at 2025-06-01 18:59
 */
public class LegalDemo {
    public static void main(String[] args) {
        // n次方
        int n = 3;
        int pow = (int) Math.pow(n, n);
        System.out.println(pow);

        // 开平方
        double sqrt = Math.sqrt(pow);
        System.out.println(sqrt);

        // 开n次方
        double pow1 = Math.pow(pow, 1.0 / 3);
        System.out.println(pow1);
    }
}
