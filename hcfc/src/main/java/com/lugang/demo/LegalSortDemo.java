package com.lugang.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wenhai.lu
 * Create at 2025-06-02 15:24
 */
public class LegalSortDemo {
    public static void main(String[] args) {

        int my = my();
        System.out.println(my);
    }

    private static int my() {
        try {
            return 11;
        } catch (Exception e) {

        } finally {
            System.out.println("agag");
        }
        return 22;
    }
    Map a=new HashMap<>();
    List b=new ArrayList<>();
}

 class A{

}