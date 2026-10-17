package com.juzi.month202603.day20260323;

/**
 * 测试继承
 * 1. 如果非静态方法,则用子类
 * 2. 如果是静态方法,则用父类,子类的静态方法被隐藏
 *
 * @author wenhai.lu
 * Create at 2026-03-23 下午 11:21
 */
public class TestExtend {
    public static void main(String[] args) {
        First first = new second();
        first.mine();
    }
}

class First {
    public void mine() {
        System.out.println("父类方法");
    }
}

class second extends First {
    public void mine() {
        System.out.println("子类方法");
    }
}