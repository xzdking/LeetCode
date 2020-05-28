package com.leetcode.array;

import java.util.HashMap;

/**
 * 205. 同构字符串
 */
public class _205_IsomorphicStrings {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character but a character may map to itself.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "egg", t = "add"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "foo", t = "bar"
     * Output: false
     * Example 3:
     * <p>
     * Input: s = "paper", t = "title"
     * Output: true
     * Note:
     * You may assume both s and t have the same length.
     *
     * @param s
     * @param t
     */
    public static boolean isomorphicStrings(String s, String t) {
        if (s == null || t == null) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!map.containsValue(b)) {
                    map.put(a, b);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isomorphicStrings2(String s, String t) {
        int[] sChars = new int[256];
        int[] tChars = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]) {
                return false;
            } else {
                sChars[s.charAt(i)] = tChars[t.charAt(i)] = t.charAt(i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
//        String s = "foo";
//        String t = "bar";
        System.out.println(isomorphicStrings(s, t));
//        System.out.println(isomorphicStrings2(s, t));
    }

}
