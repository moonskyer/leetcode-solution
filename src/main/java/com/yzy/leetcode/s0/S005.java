package com.yzy.leetcode.s0;


public class S005 {
    public static String longestPalindrome(String s) {
        return solution2(s);
    }

    //暴力法
    public static String solution1(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String test = s.substring(i, j);
                if (isPalindrome(test) && test.length() > ans.length()) {
                    ans = test;
                }
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String test) {
        for (int i = 0; i < test.length() / 2; i++) {
            if (test.charAt(i) != test.charAt(test.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //动态规划法(空间优化)
    public static String solution2(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        String t = new StringBuilder().append(s).reverse().toString();
        int length = s.length();
        int[] array = new int[length];
        int index = -1;
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (i == 0 || j == 0) {
                        array[j] = 1;
                    } else {
                        array[j] = array[j - 1] + 1;
                    }
                    if (isPalindrome(length, array[j], i, j) && array[j] > maxLength) {
                        maxLength = array[j];
                        index = i;
                    }
                } else {
                    array[j] = 0;
                }
            }
        }
        return s.substring(index + 1 - maxLength, index + 1);
    }

    private static boolean isPalindrome(int totalLength, int currentLength, int i, int j) {
        return (totalLength - 1 - i) + (currentLength - 1) == j;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abc435cba"));
    }
}
