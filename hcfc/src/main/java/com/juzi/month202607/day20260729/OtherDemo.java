package com.juzi.month202607.day20260729;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class OtherDemo {
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    private static Object lockA = new Object();
    private static Object lockB = new Object();

    /**
     * 1. 互斥
     * 2. 占有且等待,一下子获取所有锁
     * 3. 不可剥夺,超时时间
     * 4. 循环等待,有序调整
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        new Thread(() -> {
            lock1.lock();
            System.out.println("线程1的1锁");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock2.lock();
            lock2.unlock();
            lock1.unlock();

        }).start();
        new Thread(() -> {
            lock2.lock();
            System.out.println("线程2的2锁");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock1.lock();
            lock1.unlock();
            lock2.unlock();

        }).start();
    }

    /**
     * 实现死锁
     */
    private static void useSync() {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println("线程1的a锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockB) {
                    System.out.println("线程1的b锁");
                }

            }
        }).start();

        new Thread(() -> {
            synchronized (lockB) {
                System.out.println("线程2的b锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockA) {
                    System.out.println("线程2的a锁");
                }

            }
        }).start();
    }

    /**
     * 线程池的实现
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void executorsDemo() throws InterruptedException, ExecutionException {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Future<List<Integer>> submit = executorService.submit(() -> {
            List<Integer> oneList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 1) {
                    oneList.add(a[i]);
                }
            }
            return oneList;
        });
        Future<List<Integer>> towFuture = executorService.submit(() -> {
            List<Integer> twoList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 0) {
                    twoList.add(a[i]);
                }
            }
            return twoList;
        });
        List<Integer> integers = submit.get();
        List<Integer> integers1 = towFuture.get();
        System.out.println(integers1);
        System.out.println(integers);
    }
}
