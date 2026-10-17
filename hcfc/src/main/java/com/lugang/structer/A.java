package com.lugang.structer;

public class A implements B {
    public static void main(String[] args) {
        A first = new A();
        String a = first.a;
    }

}

interface B {
    String a = null;
}