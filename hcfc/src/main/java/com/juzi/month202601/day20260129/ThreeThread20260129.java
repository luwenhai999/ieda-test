package com.juzi.month202601.day20260129;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程以此输出数据
 *
 * @author wenhai.lu
 * Create at 2026-01-29 21:00
 */
public class ThreeThread20260129 {
    private static Object lockObj = new Object();
    private static String state = "A";
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

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
                    System.out.println("A");
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
                    System.out.println("B");
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

    private static void useExecutorAndSemaphore() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Semaphore sa = new Semaphore(1);
        Semaphore sb = new Semaphore(0);
        Semaphore sc = new Semaphore(0);
        threadPool.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sa.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(Thread.currentThread().getId() + ":A");
                sb.release();
            }
        });
        threadPool.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sb.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(Thread.currentThread().getId() + ":B");
                sc.release();
            }
        });
        threadPool.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + ":C");
                sa.release();
            }
        });
    }

    private static void useReentrantLock() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread ta = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 加锁
                lock.lock();
                // 如果非目标值,则等待
                while (!state.equals("A")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                state = "B";
                // 唤醒其他的wait的线程
                condition.signalAll();
                // 释放锁
                lock.unlock();
            }
        });
        Thread tb = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 加锁
                lock.lock();
                // 如果非目标值,则等待
                while (!state.equals("B")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                state = "C";
                // 唤醒其他的wait的线程
                condition.signalAll();
                // 释放锁
                lock.unlock();
            }
        });
        Thread tc = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 加锁
                lock.lock();
                // 如果非目标值,则等待
                while (!state.equals("C")) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                state = "A";
                // 唤醒其他的wait的线程
                condition.signalAll();
                // 释放锁
                lock.unlock();
            }
        });
        ta.start();
        tb.start();
        tc.start();
    }

    private static void useSemaphore() {
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
                    sc.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
                sa.release();
            }
        });
        ta.start();
        tb.start();
        tc.start();
    }

    private static void useExecutors() {
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
                    System.out.print("A");
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
                    System.out.print("B");
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
                    System.out.println("C");
                    state = "A";
                    lockObj.notifyAll();
                }
            }
        });
    }

    private static void useSynchronized() {
        // 创建线程
        // 只有当状态值与预期相同时才会继续执行,否则就等待
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
        Thread tb = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lockObj) {
                        // 如果预期值不符合,则需要等待
                        while (!state.equals("B")) {
                            try {
                                lockObj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.print("B");
                        state = "C";
                        lockObj.notifyAll();
                    }
                }
            }
        };
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

}
