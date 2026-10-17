package com.juzi.month202603.day20260316;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程并行执行
 *
 * @author wenhai.lu
 * Create at 2026-03-16 下午 10:00
 */
public class ExecutorsParrelSubmitFutureGet {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(3);
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Future<List<Integer>> oneFuture = executors.submit(() -> {
            List<Integer> oneList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 3 == 1) {
                    oneList.add(a[i]);
                }
            }
            return oneList;
        });
        Future<List<Integer>> twoFuture = executors.submit(() -> {
            List<Integer> twoList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 3 == 2) {
                    twoList.add(a[i]);
                }
            }
            return twoList;
        });
        List<Integer> integers = oneFuture.get();
        List<Integer> integers1 = twoFuture.get();
        System.out.println(integers);
        System.out.println(integers1);
        executors.shutdown();
    }

}
