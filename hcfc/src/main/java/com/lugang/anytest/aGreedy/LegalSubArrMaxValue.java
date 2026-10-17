package com.lugang.anytest.aGreedy;

/**
 * 最大子数组的和
 *
 * @author wenhai.lu
 * Create at 2025-05-03 22:39
 */
public class LegalSubArrMaxValue {
    /**
     * 如果当前和市负数,则向后累加的时候只会使总和更小,所以出现负数的时候要置成零
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {-2, -11, -3, -4, -11, -2, -111, -5, -4};
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int thisNum : arr) {
            sum += thisNum;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(max);
    }

    /**
     * 求最大值,暴力求解法
     */
    private static void firstMaxSum() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int thisSum = 0;
            for (int j = i; j < arr.length; j++) {
                thisSum += arr[j];
                max = Math.max(thisSum, max);
            }
        }
        System.out.println(max);
    }
}
