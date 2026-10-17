package com.juzi.month202604.day20260401;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author wenhai.lu
 * Create at 2026-04-01 下午 7:22
 */
public class H2oDemo {


    public static void main(String[] args) {
        String str = "HOOOHHHOOHHHHHH";
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Semaphore so = new Semaphore(0);
        Semaphore sh = new Semaphore(2);
        // 输出O
        executorService.execute(() -> {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'O') {
                    try {
                        so.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(str.charAt(i));
                    sh.release(2);
                }
            }
        });
        // 输出H
        executorService.execute(() -> {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'H') {
                    try {
                        sh.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(str.charAt(i));
                    if (sh.availablePermits() == 0) {
                        so.release();
                    }
                }
            }
        });
    }


//    public static void main(String[] args) {
//        String str = "OOHHHH";
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        // 输出h
//        executorService.execute(() -> {
//            for (int i = 0; i < str.length(); i++) {
//                synchronized (str) {
//                    while (hNum > 2) {
//                        try {
//                            str.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }
//            }
//        });
//
//    }
}
