package com.juzi.month202603.day20260327;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenhai.lu
 * Create at 2026-03-27 下午 10:09
 */
public class MapDemocomputeIfAbsent {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.getOrDefault(1, 1);
        map.computeIfAbsent(1, k -> 1);
    }
}
