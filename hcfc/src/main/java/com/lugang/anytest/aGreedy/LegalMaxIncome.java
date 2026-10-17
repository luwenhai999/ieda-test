package com.lugang.anytest.aGreedy;

/**
 * 买卖股票最佳时机
 *
 * @author wenhai.lu
 * Create at 2025-05-03 23:47
 */
public class LegalMaxIncome {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            int thisIncome = arr[i] - arr[i - 1];
            if (thisIncome > 0) {
                sum += thisIncome;
            }
        }
        System.out.println(sum);
    }
}
