package com.leetcode.parentheses;

public class _214_ShortestPalindrome {

  /**
   * 214. 最短回文串
   *
   * <p>给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
   *
   * <p>示例 1:
   *
   * <p>输入: "aacecaaa" 输出: "aaacecaaa"
   *
   * <p>示例 2:
   *
   * <p>输入: "abcd" 输出: "dcbabcd"
   *
   * @param s
   * @return
   */
  public static String shortestPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    int end = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        i = 0;
        end--;
        j = end;
      }
    }
    return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
  }

  public static void main(String[] args) {
    String s = "aacecaaa";
    //    String s = "abcd";
    System.out.println(shortestPalindrome(s));
  }
}
