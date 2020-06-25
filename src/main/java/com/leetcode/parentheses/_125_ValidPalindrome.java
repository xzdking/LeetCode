package com.leetcode.parentheses;

public class _125_ValidPalindrome {

  /**
   * 125. 验证回文串
   *
   * <p>给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
   *
   * <p>说明：本题中，我们将空字符串定义为有效的回文串。
   *
   * <p>示例 1:
   *
   * <p>输入: "A man, a plan, a canal: Panama" 输出: true
   *
   * <p>示例 2:
   *
   * <p>输入: "race a car" 输出: false
   *
   * @param s
   * @return
   */
  public static boolean validPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    //    String s = "race a car";
    System.out.println(validPalindrome(s));
  }
}
