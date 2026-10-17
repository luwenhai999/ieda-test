package com.juzi.month202604.day20260425;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/**
 * 三个线程轮流打印
 *
 * @author wenhai.lu
 * Create at 2026-04-25 下午 9:26
 */
public class ThreeThreadPrint {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Semaphore sa = new Semaphore(1);
        Semaphore sb = new Semaphore(0);
        Semaphore sc = new Semaphore(0);

        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sa.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(Thread.currentThread().getName() + "A");
                sb.release();
            }
        });
        Future<String> submit = executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sb.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(Thread.currentThread().getName() + "B");
                sc.release();
            }
            return "";
        });
        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "C");
                sa.release();
            }
        });
    }

}
