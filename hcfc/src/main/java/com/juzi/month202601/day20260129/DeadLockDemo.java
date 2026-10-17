package com.juzi.month202601.day20260129;

/**
 * 死锁场景创建
 *
 * @author wenhai.lu
 * Create at 2026-01-29 22:29
 */
public class DeadLockDemo {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1-1执行");
                synchronized (lock2) {
                    System.out.println("线程1-2执行");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2-1执行");
                synchronized (lock1) {
                    System.out.println("线程2-2执行");
                }
            }
        });
        t1.start();
        t2.start();

    }

    public static void main1(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第一个线程输出1");
                synchronized (lock2) {
                    System.out.println("第一个线程输出2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第二个线程输出1");
                synchronized (lock1) {
                    System.out.println("第二个线程输出2");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
