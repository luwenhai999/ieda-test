package com.juzi.month202603.day20260326;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 三个线程轮流打出
 * 1. semaphore
 * 2. countDownLunch
 *
 * @author wenhai.lu
 * Create at 2026-03-26 下午 10:13
 */
public class ThreePrintSortDemo {
    private static String state = "A";

    public static void main(String[] args) {
        // 通过countDownLunch,空了才会执行,await会等待,知道别的线程都countDown为止
        // 这个countDownLatch适合做收集并行处理的结果
        CountDownLatch countDownLatch = new CountDownLatch(1);

    }

    private static void useSemaphore() {
        // 通过semaphore,有了令牌才会执行
        Semaphore sa = new Semaphore(1);
        Semaphore sb = new Semaphore(0);
        Semaphore sc = new Semaphore(0);
        Thread ta = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sa.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("A");
                sb.release();
            }
        });
        Thread tb = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sb.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("B");
                sc.release();
            }
        });
        Thread tc = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    //如果没有信号量,则会一直等待;只有当b输出后才会修改这里的信号量
                    sc.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
                sa.release();
            }
        });
        tc.start();
        tb.start();
        ta.start();
    }
}
