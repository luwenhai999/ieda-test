package com.juzi.month202603.day20260308;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印
 *
 * @author wenhai.lu
 * Create at 2026-03-08 下午 7:55
 */
public class ThreeThreadPrint {
    private static String state = "A";
    private static Object lockObj = new Object();

    public static void main(String[] args) {
        Thread ta = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObj) {
                    while (!state.equals("A")) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    state = "B";
                    lockObj.notifyAll();
                }
            }
        });
        Thread tb = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObj) {
                    while (!state.equals("B")) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    state = "C";
                    lockObj.notifyAll();
                }
            }
        });
        Thread tc = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObj) {
                    while (!state.equals("C")) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    state = "A";
                    lockObj.notifyAll();
                }
            }
        });
        ta.start();
        tb.start();
        tc.start();
    }

    public static void main1(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread ta = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!state.equals("A")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                state = "B";
                condition.signalAll();
                lock.unlock();
            }
        });
        Thread tb = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!state.equals("B")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                state = "C";
                condition.signalAll();
                lock.unlock();
            }
        });
        Thread tc = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!state.equals("C")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                state = "A";
                condition.signalAll();
                lock.unlock();
            }
        });
        ta.start();
        tb.start();
        tc.start();
    }
}
