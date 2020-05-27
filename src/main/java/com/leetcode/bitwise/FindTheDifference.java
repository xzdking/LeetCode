package com.leetcode.bitwise;

/**
 * 位运算
 * 异或：
 * 相同为零 不同为一
 * 任何数异或0等于其本身
 * LeetCode 389
 */
public class FindTheDifference {

    private static String s = "abcd";
    private static String t = "abcde";

    public static char solve(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    public static void main(String[] args) {

        System.out.println(solve(s, t));

    }

}
