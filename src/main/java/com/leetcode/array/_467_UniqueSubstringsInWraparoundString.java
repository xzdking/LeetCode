package com.leetcode.array;

public class _467_UniqueSubstringsInWraparoundString {

  /**
   * Consider the string s to be the infinite wraparound string of "abcdefghijklmno pqrstuvwxyz", so
   * s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghi jklmnopqrstuvwxyzabcd....".
   *
   * <p>Now we have another string p. Your job is to find out how many unique non-emp ty substrings
   * of p are present in s. In particular, your input is the string p a nd you need to output the
   * number of different non-empty substrings of p in the s tring s.
   *
   * <p>Note: p consists of only lowercase English letters and the size of p might be over 10000.
   *
   * <p>Example 1:
   *
   * <p>Input: "a" Output: 1
   *
   * <p>Explanation: Only the substring "a" of string "a" is in the string s.
   *
   * <p>Example 2:
   *
   * <p>Input: "cac" Output: 2 Explanation: There are two substrings "a", "c" of string "cac" in the
   * string s .
   *
   * <p>Example 3:
   *
   * <p>Input: "zab" Output: 6 Explanation: There are six substrings "z", "a", "b", "za", "ab",
   * "zab" of stri ng "zab" in the string s.
   *
   * @param p
   * @return
   */
  public static int uniqueSubstringsInWraparoundString(String p) {
    int[] count = new int[26];
    int curMax = 0;
    for (int i = 0; i < p.length(); i++) {
      if (i > 0
          && ((p.charAt(i) - p.charAt(i - 1) == 1) || (p.charAt(i) - p.charAt(i - 1) == 25))) {
        curMax++;
      } else {
        curMax = 1;
      }
      count[p.charAt(i) - 'a'] = Math.max(curMax, count[p.charAt(i) - 'a']);
    }
    int res = 0;
    for (int num : count) {
      res += num;
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "cac";
    System.out.println(uniqueSubstringsInWraparoundString(s));
  }
}
