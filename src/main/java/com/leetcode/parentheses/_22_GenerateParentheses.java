package com.leetcode.parentheses;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {

  /**
   * 22. 括号生成
   *
   * <p>数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
   *
   * <p>示例：
   *
   * <p>输入：n = 3 输出：[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
   *
   * @param n
   * @return
   */
  public static List<String> generateParentheses(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }
    helper(res, "", n, n);
    return res;
  }

  public static void helper(List<String> res, String s, int left, int right) {
    if (left > right) {
      return;
    }
    if (left == 0 && right == 0) {
      res.add(s);
      return;
    }
    if (left > 0) {
      helper(res, s + "(", left - 1, right);
    }
    if (right > 0) {
      helper(res, s + ")", left, right - 1);
    }
  }

  public static void main(String[] args) {
    int n = 3;
    System.out.println(generateParentheses(n));
  }
}
