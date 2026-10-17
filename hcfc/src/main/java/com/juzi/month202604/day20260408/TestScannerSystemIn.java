package com.juzi.month202604.day20260408;

import java.util.Scanner;

/**
 * @author wenhai.lu
 * Create at 2026-04-08 下午 3:34
 */
public class TestScannerSystemIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入年龄");
        int age = scanner.nextInt();
//        scanner.nextLine();

        System.out.println("输入身高");
        int height = scanner.nextInt();
//        scanner.nextLine();


        System.out.println("输入姓名");
        String name = scanner.nextLine();

        System.out.println("年龄: " + age);
        System.out.println("身高: " + height);
        System.out.println("姓名: " + name);
    }
}
