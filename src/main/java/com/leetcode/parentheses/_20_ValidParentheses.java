package com.leetcode.parentheses;

import java.util.Stack;

public class _20_ValidParentheses {

  /**
   * 20. 有效的括号
   *
   * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
   *
   * <p>有效字符串需满足：
   *
   * <p>左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
   *
   * <p>示例 1:
   *
   * <p>输入: "()" 输出: true
   *
   * <p>示例 2:
   *
   * <p>输入: "()[]{}" 输出: true
   *
   * <p>示例 3:
   *
   * <p>输入: "(]" 输出: false
   *
   * <p>示例 4:
   *
   * <p>输入: "([)]" 输出: false
   *
   * <p>示例 5:
   *
   * <p>输入: "{[]}" 输出: true
   *
   * @param s
   * @return
   */
  public static boolean validParentheses(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Stack<Character> stack = new Stack<>();
    for (Character ch : s.toCharArray()) {
      if (ch == '{') {
        stack.push('}');
      } else if (ch == '[') {
        stack.push(']');
      } else if (ch == '(') {
        stack.push(')');
      } else {
        if (stack.isEmpty() || !stack.pop().equals(ch)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String s = "()[]{}";
    System.out.println(validParentheses(s));
  }
}
