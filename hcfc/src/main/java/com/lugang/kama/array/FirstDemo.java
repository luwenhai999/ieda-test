package com.lugang.kama.array;

/**
 * 数组-超过指定目标数,和,最小个数
 *
 * @author wenhai.lu
 * Create at 2025-06-27 17:39
 */
public class FirstDemo {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int slow = 0;
        int fast = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (fast < arr.length) {
            sum += arr[fast];
            while (sum >= target) {
                minLength = Math.min(minLength, fast - slow + 1);
                sum -= arr[slow];
                slow++;
            }
            fast++;
        }
        System.out.println(minLength);
    }

}
