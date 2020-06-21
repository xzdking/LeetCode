package com.leetcode.parentheses;

import java.util.Stack;

public class _32_LongestValidParentheses {

  /**
   * 32. 最长有效括号
   *
   * <p>给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
   *
   * <p>示例 1:
   *
   * <p>输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()"
   *
   * <p>示例 2:
   *
   * <p>输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
   *
   * @param s
   * @return
   */
  public static int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    int start = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        if (stack.isEmpty()) {
          start = i;
        } else {
          stack.pop();
          if (stack.isEmpty()) {
            res = Math.max(res, i - start);
          } else {
            res = Math.max(res, i - stack.peek());
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String s = ")()())";
    System.out.println(longestValidParentheses(s));
  }
}
