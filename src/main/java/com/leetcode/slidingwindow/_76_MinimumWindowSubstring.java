package com.leetcode.slidingwindow;

public class _76_MinimumWindowSubstring {

  /**
   * 76. 最小覆盖子串 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
   *
   * <p>示例：
   *
   * <p>输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC" 说明：
   *
   * <p>如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
   *
   * @param s
   * @param t
   * @return
   */
  public static String minimumWindowSubstring(String s, String t) {
    int[] cnt = new int[128];
    for (char c : t.toCharArray()) {
      cnt[c]++;
    }
    int from = 0;
    int total = t.length();
    int min = Integer.MAX_VALUE;
    // 双指针
    for (int i = 0, j = 0; i < s.length(); i++) {
      if (cnt[s.charAt(i)]-- > 0) {
        total--;
      }
      while (total == 0) {
        if (i - j + 1 < min) {
          min = i - j + 1;
          from = j;
        }
        if (++cnt[s.charAt(j++)] > 0) {
          total++;
        }
      }
    }
    return (min == Integer.MAX_VALUE ? "" : s.substring(from, from + min));
  }

  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(minimumWindowSubstring(s, t));
  }
}
