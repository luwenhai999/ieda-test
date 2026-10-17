package com.juzi.month202603.day20260312;

/**
 * @author wenhai.lu
 * Create at 2026-03-12 下午 3:28
 */
public class SingleDemo {
    public static void main(String[] args) {
        Ab instance = Ab.getInstance();
        System.out.println(instance);
    }
}

class Ab {
    private static Ab instance;

    @Override
    public String toString() {
        Thread a;
        return "I'm a single instance!";
    }

    private Ab() {

    }

    public static Ab getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Ab.class) {
            if (instance != null) {
                return instance;
            }
            instance = new Ab();
            return instance;
        }
    }
}