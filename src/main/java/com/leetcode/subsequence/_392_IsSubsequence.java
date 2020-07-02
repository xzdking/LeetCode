package com.leetcode.subsequence;

public class _392_IsSubsequence {

  /**
   * 392. 判断子序列
   *
   * <p>给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
   *
   * <p>你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
   *
   * <p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
   *
   * <p>示例 1: s = "abc", t = "ahbgdc"
   *
   * <p>返回 true.
   *
   * <p>示例 2: s = "axc", t = "ahbgdc"
   *
   * <p>返回 false.
   *
   * <p>后续挑战 :
   *
   * <p>如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
   *
   * @param s
   * @param t
   * @return
   */
  public static boolean isSubsequence(String s, String t) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int i = 0;
    int j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }

  public static void main(String[] args) {
    String s = "axc";
    String t = "ahbgdc";
    System.out.println(isSubsequence(s, t));
  }
}
