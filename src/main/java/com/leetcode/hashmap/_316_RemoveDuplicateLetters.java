package com.leetcode.hashmap;

import java.util.HashMap;

public class _316_RemoveDuplicateLetters {

  /**
   * 316. 去除重复字母
   *
   * <p>给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
   *
   * <p>示例 1:
   *
   * <p>输入: "bcabc" 输出: "abc"
   *
   * <p>示例 2:
   *
   * <p>输入: "cbacdcbc" 输出: "acdb"
   *
   * @param s
   * @return
   */
  public static String removeDuplicateLetters(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), i);
    }
    char[] res = new char[map.size()];
    int start = 0, end = findMinLastPos(map);
    for (int i = 0; i < res.length; i++) {
      char minChar = 'z' + 1;
      for (int k = start; k <= end; k++) {
        if (map.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
          minChar = s.charAt(k);
          start = k + 1;
        }
      }
      res[i] = minChar;
      map.remove(minChar);
      if (s.charAt(end) == minChar) {
        end = findMinLastPos(map);
      }
    }
    return new String(res);
  }

  private static int findMinLastPos(HashMap<Character, Integer> map) {
    int res = Integer.MAX_VALUE;
    for (int num : map.values()) {
      res = Math.min(res, num);
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "bcabc";
    //    String s = "cbacdcbc";
    System.out.println(removeDuplicateLetters(s));
  }
}
