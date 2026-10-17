package com.juzi.month202603.day20260317;

/**
 * 三个线程打印
 *
 * @author wenhai.lu
 * Create at 2026-03-17 下午 1:35
 */
public class ThreeThredPrint {
    private static Object lockObj = new Object();
    private static String state = "A";

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
        tc.start();
        tb.start();
        ta.start();

    }
}
