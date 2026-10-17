package com.juzi.month202601.day20260129;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用线程池并行处理
 *
 * @author wenhai.lu
 * Create at 2026-01-29 22:41
 */
public class ExecutorsDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(3);
        int[] a = {1, 2, 4, 4, 5, 3, 7, 8, 12, 10};
        Future<List<Integer>> jishuFuture = executors.submit(() -> {
            List<Integer> jishuList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 1) {
                    jishuList.add(a[i]);
                }
            }
            return jishuList;
        });
        Future<List<Integer>> oushuFuture = executors.submit(() -> {
            List<Integer> oushuList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 0) {
                    oushuList.add(a[i]);
                }
            }
            return oushuList;
        });
        List<Integer> integers = jishuFuture.get();
        List<Integer> integers1 = oushuFuture.get();
        System.out.println(integers);
        System.out.println(integers1);
    }

    public static void main1(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int[] a = {1, 2, 4, 4, 5, 3, 7, 8, 12, 10};
        Future<List<Integer>> zeroFuture = executorService.submit(() -> {
            List<Integer> zeroList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (i % 2 != 0) {
                    continue;
                }
                Thread.sleep(1000);
                if (a[i] % 2 == 0) {
                    System.out.println(Thread.currentThread() + ",获取的值为:" + a[i]);
                    zeroList.add(a[i]);
                }
            }
            return zeroList;
        });
        Future<List<Integer>> oneFuture = executorService.submit(() -> {
            List<Integer> zeroList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (i % 2 != 1) {
                    continue;
                }
                if (a[i] % 2 == 0) {
                    System.out.println(Thread.currentThread() + ",获取的值为:" + a[i]);
                    zeroList.add(a[i]);
                }
            }
            return zeroList;
        });
        List<Integer> zeroList = zeroFuture.get();
        List<Integer> oneList = oneFuture.get();
        System.out.println(zeroList);
        System.out.println(oneList);

    }
}
