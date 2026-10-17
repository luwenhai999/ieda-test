package com.juzi.month202603.day20260316;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 生成一个死锁
 * 1. synchorize
 * 2. reentrantLock
 *
 * @author wenhai.lu
 * Create at 2026-03-16 下午 10:06
 */
public class DeadLockDemo {
    private static Object lockObj = new Object();
    private static Object lockObjB = new Object();
    // t1:
    // update table1 where field='a';
    // update table2 where field='b';

    // t2:
    // update table2 where field='b';
    // update table1 where field='a';

    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        Thread t12 = new Thread(() -> {
            lock1.lock();
            System.out.println("lock1锁上了");
            lock2.lock();
            System.out.println("lock1锁上了,同时lock2也锁上了");
            lock2.unlock();
            lock1.unlock();
        });
        Thread t21 = new Thread(() -> {
            lock2.lock();
            System.out.println("lock2锁上了");
            lock1.lock();
            System.out.println("lock2锁上了,同时lock1也锁上了");
            lock1.unlock();
            lock2.unlock();
        });
        t12.start();
        t21.start();
    }

    private static void synchorized() {
        Thread tab = new Thread(() -> {
            synchronized (lockObj) {
                System.out.println(Thread.currentThread().getName() + ":lockObj已经被锁了");
                synchronized (lockObjB) {
                    System.out.println(Thread.currentThread().getName() + ":lockobj被锁的同时,B也被锁了");
                }
            }
        });
        Thread tba = new Thread(() -> {
            synchronized (lockObjB) {
                System.out.println(Thread.currentThread().getName() + ":lockObjB已经被锁了");
                synchronized (lockObj) {
                    System.out.println(Thread.currentThread().getName() + ":lockobjB被锁的同时,lockObj也被锁了");
                }
            }
        });
        tab.start();
        tba.start();
    }
}
