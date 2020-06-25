package com.leetcode.parentheses;

public class _9_PalindromeNumber {

  /**
   * 9. 回文数
   *
   * <p>判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
   *
   * <p>示例 1:
   *
   * <p>输入: 121 输出: true
   *
   * <p>示例 2:
   *
   * <p>输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
   *
   * <p>示例 3:
   *
   * <p>输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。
   *
   * <p>进阶:
   *
   * <p>你能不将整数转为字符串来解决这个问题吗？
   *
   * @param x
   * @return
   */
  public static boolean palindromeNumber(int x) {
    if (x < 0 || x != 0 && x % 10 == 0) {
      return false;
    }
    int palind = x;
    int rev = 0;
    while (x > 0) {
      rev = rev * 10 + x % 10;
      x /= 10;
    }
    return palind == rev;
  }

  public static void main(String[] args) {
    int x = 121;
    System.out.println(palindromeNumber(x));
  }
}
