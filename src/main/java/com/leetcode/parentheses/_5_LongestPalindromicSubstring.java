package com.leetcode.parentheses;

public class _5_LongestPalindromicSubstring {

  /**
   * 5. 最长回文子串
   *
   * <p>给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
   *
   * <p>示例 1：
   *
   * <p>输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
   *
   * <p>示例 2：
   *
   * <p>输入: "cbbd" 输出: "bb"
   *
   * @param s
   * @return
   */
  public static String longestPalindromicSubstring(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    String res = "";
    boolean[][] dp = new boolean[s.length()][s.length()];
    int max = 0;
    for (int j = 0; j < s.length(); j++) {
      for (int i = 0; i <= j; i++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
        if (dp[i][j]) {
          if (j - i + 1 > max) {
            max = j - i + 1;
            res = s.substring(i, j + 1);
          }
        }
      }
    }
    return res;
  }

  // time:O(n^2) space:O(1)
  static String res = "";

  public static String longestPalindromicSubstring2(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    for (int i = 0; i < s.length(); i++) {
      helper(s, i, i);
      helper(s, i, i + 1);
    }
    return res;
  }

  private static void helper(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    String cur = s.substring(left + 1, right);
    if (cur.length() > res.length()) {
      res = cur;
    }
  }

  public static void main(String[] args) {
//    String s = "babad";
        String s = "cbbd";
    System.out.println(longestPalindromicSubstring(s));
    System.out.println(longestPalindromicSubstring2(s));
  }
}
