package com.leetcode.array;

public class ScrambleString {

    /**
     * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
     * <p>
     * Below is one possible representation of s1 = "great":
     * <p>
     * great
     * /    \
     * gr    eat
     * / \    /  \
     * g   r  e   at
     * / \
     * a   t
     * To scramble the string, we may choose any non-leaf node and swap its two children.
     * <p>
     * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
     * <p>
     * rgeat
     * /    \
     * rg    eat
     * / \    /  \
     * r   g  e   at
     * / \
     * a   t
     * We say that "rgeat" is a scrambled string of "great".
     * <p>
     * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
     * <p>
     * rgtae
     * /    \
     * rg    tae
     * / \    /  \
     * r   g  ta  e
     * / \
     * t   a
     * We say that "rgtae" is a scrambled string of "great".
     * <p>
     * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
     * <p>
     * Example 1:
     * <p>
     * Input: s1 = "great", s2 = "rgeat"
     * Output: true
     * Example 2:
     * <p>
     * Input: s1 = "abcde", s2 = "caebd"
     * Output: false
     *
     *  解法使用 三维DP
     * @param s1
     * @param s2
     * @return
     */
    // 该题使用递归方法 time:O(n!) space:O(n)
    public static boolean scrambleString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] letters = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < len; i++) {
            if (scrambleString(s1.substring(0, i), s2.substring(0, i))
                    && scrambleString(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (scrambleString(s1.substring(0, i), s2.substring(len - i))
                    && scrambleString(s1.substring(i), s2.substring(0, len - i))
            ) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //        String s1 = "great";
        //        String s2 = "rgeat";
        String s1 = "abcde";
        String s2 = "caebd";
        System.out.println(scrambleString(s1, s2));
    }
}
