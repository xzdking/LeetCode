package com.leetcode.parentheses;

import java.util.ArrayList;
import java.util.List;

public class _241_DifferentWaysToAddParentheses {

  /**
   * 241. 为运算表达式设计优先级
   *
   * <p>给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
   *
   * <p>示例 1:
   *
   * <p>输入: "2-1-1" 输出: [0, 2] 解释: ((2-1)-1) = 0 (2-(1-1)) = 2
   *
   * <p>示例 2:
   *
   * <p>输入: "2*3-4*5" 输出: [-34, -14, -10, -10, 10] 解释: (2*(3-(4*5))) = -34 ((2*3)-(4*5)) = -14
   * ((2*(3-4))*5) = -10 (2*((3-4)*5)) = -10 (((2*3)-4)*5) = 10
   *
   * @param input
   * @return
   */
  public static List<Integer> differentWaysToAddParentheses(String input) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '-' || c == '+' || c == '*') {
        String a = input.substring(0, i);
        String b = input.substring(i + 1);
        List<Integer> al = differentWaysToAddParentheses(a);
        List<Integer> bl = differentWaysToAddParentheses(b);
        for (int x : al) {
          for (int y : bl) {
            if (c == '-') {
              res.add(x - y);
            } else if (c == '+') {
              res.add(x + y);
            } else if (c == '*') {
              res.add(x * y);
            }
          }
        }
      }
    }
    if (res.size() == 0) {
      res.add(Integer.valueOf(input));
    }
    return res;
  }

  public static void main(String[] args) {
    String str = "2*3-4*5";
    System.out.println(differentWaysToAddParentheses(str));
  }
}
