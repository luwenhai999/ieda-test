package com.lugang.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wenhai.lu
 * Create at 2025-06-27 16:08
 */
public class LegalThreadDEMO {

    private static String state = "A";
    private static Object lockObj = new Object();

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread tA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                if (!state.equals("A")) {
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(state);
                state = "B";
                conditionB.signal();
                lock.unlock();
            }
        });
        Thread tB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                if (!state.equals("B")) {
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(state);
                state = "C";
                conditionC.signal();
                lock.unlock();
            }
        });
        Thread tC = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                if (!state.equals("C")) {
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(state);
                state = "A";
                conditionA.signal();
                lock.unlock();
            }
        });
        tA.start();
        tB.start();
        tC.start();

    }

    /**
     * 使用thread,reentrantLock
     */
    private static void useReentrantLockThread() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread tA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!state.equals("A")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(state);
                state = "B";
                condition.signalAll();
                lock.unlock();
            }
        });
        Thread tB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!state.equals("B")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(state);
                state = "C";
                condition.signalAll();
                lock.unlock();
            }
        });
        Thread tC = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (!state.equals("C")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(state);
                state = "A";
                condition.signalAll();
                lock.unlock();
            }
        });
        tA.start();
        tB.start();
        tC.start();
    }

    /**
     * 使用线程池的方式
     */
    private static void useThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObj) {
                    while (!state.equals("A")) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getId() + " : " + state);
                    state = "B";
                    lockObj.notifyAll();
                }
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObj) {
                    while (!state.equals("B")) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getId() + " : " + state);
                    state = "C";
                    lockObj.notifyAll();
                }
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObj) {
                    while (!state.equals("C")) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getId() + " : " + state);
                    state = "A";
                    lockObj.notifyAll();
                }
            }
        });
    }
}
