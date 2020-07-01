package com.leetcode.parentheses;

import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {

  /**
   * 131. 分割回文串
   *
   * <p>给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
   *
   * <p>返回 s 所有可能的分割方案。
   *
   * <p>示例:
   *
   * <p>输入: "aab"
   *
   * <p>输出: [ ["aa","b"], ["a","a","b"] ]
   *
   * @param s
   * @return
   */
  public static List<List<String>> palindromePartitioning(String s) {
    List<List<String>> res = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return res;
    }
    helper(res, new ArrayList<>(), s);
    return res;
  }

  public static void helper(List<List<String>> res, List<String> list, String s) {
    if (s.length() == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      if (isPalindrome(s.substring(0, i + 1))) {
        list.add(s.substring(0, i + 1));
        helper(res, list, s.substring(i + 1));
        list.remove(list.size() - 1);
      }
    }
  }

  public static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "aab";
    System.out.println(palindromePartitioning(s));
  }
}
