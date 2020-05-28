package com.leetcode.array;

public class RansomNote {

    /**
     * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
     * <p>
     * Each letter in the magazine string can only be used once in your ransom note.
     * <p>
     * Example 1:
     * <p>
     * Input: ransomNote = "a", magazine = "b"
     * Output: false
     * Example 2:
     * <p>
     * Input: ransomNote = "aa", magazine = "ab"
     * Output: false
     * Example 3:
     * <p>
     * Input: ransomNote = "aa", magazine = "aab"
     * Output: true
     * <p>
     * Constraints:
     * <p>
     * You may assume that both strings contain only lowercase letters.
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    // Tip：重复字母的个数
    public static boolean ransomNote(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransonNote = "a";
        String magazine = "b";
        System.out.println(ransomNote(ransonNote, magazine));
    }
}
