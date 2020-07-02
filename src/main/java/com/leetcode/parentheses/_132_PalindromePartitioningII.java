package com.leetcode.parentheses;

public class _132_PalindromePartitioningII {

  /**
   * 132. 分割回文串 II
   *
   * <p>给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
   *
   * <p>返回符合要求的最少分割次数。
   *
   * <p>示例:
   *
   * <p>输入: "aab"
   *
   * <p>输出: 1
   *
   * <p>解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
   *
   * @param s
   * @return
   */
  public static int palindromePartitioningII(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int len = s.length();
    int[] cuts = new int[len];
    boolean[][] isPalindrome = new boolean[len][len];

    for (int i = 0; i < len; i++) {
      int min = 1;
      for (int j = 0; j <= i; j++) {
        if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
          isPalindrome[j][i] = true;
          min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
        }
      }
      cuts[i] = min;
    }
    return cuts[len - 1];
  }

  public static void main(String[] args) {
    String s = "aab";
    System.out.println(palindromePartitioningII(s));
  }
}
