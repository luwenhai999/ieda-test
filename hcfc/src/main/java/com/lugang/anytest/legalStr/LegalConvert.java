package com.lugang.anytest.legalStr;

public class LegalConvert {
    public static void main(String[] args) {
        System.out.println(convert2k("12345678901234567890123", 5));
    }

    private static String convert2k(String str, int k) {
        int page = str.length() / (2 * k);
        int i = 0;
        char[] charArr = str.toCharArray();
        while (i < page) {
            int left = i * k * 2;
            int right = i * k * 2 + k - 1;
            swap(charArr, left, right);
            i++;
        }
        if (str.length() - i * k * 2 <= k) {
            swap(charArr, i * k * 2, str.length() - 1);
        } else {
            swap(charArr, i * k * 2, i * k * 2 + k - 1);
        }
        return String.copyValueOf(charArr);
    }

    private static void swap(char[] charArr, int left, int right) {
        while (left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }
    }

    private static String convert(String a) {
        if (a == null || a.length() == 1) {
            return a;
        }
        char[] charArr = a.toCharArray();
        int left = 0;
        int right = charArr.length - 1;
        while (left < right) {
            char leftChar = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = leftChar;
            left++;
            right--;
        }
        return String.copyValueOf(charArr);
    }
}
