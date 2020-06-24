package com.leetcode.hashmap;

import java.util.HashMap;

public class _290_WordPattern {

  /**
   * 290. 单词规律
   *
   * <p>给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
   *
   * <p>这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
   *
   * <p>示例1:
   *
   * <p>输入: pattern = "abba", str = "dog cat cat dog" 输出: true
   *
   * <p>示例 2:
   *
   * <p>输入:pattern = "abba", str = "dog cat cat fish" 输出: false
   *
   * <p>示例 3:
   *
   * <p>输入: pattern = "aaaa", str = "dog cat cat dog" 输出: false
   *
   * <p>示例 4:
   *
   * <p>输入: pattern = "abba", str = "dog dog dog dog" 输出: false
   *
   * <p>说明: 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
   *
   * @param pattern
   * @param str
   * @return
   */
  public static boolean wordPattern(String pattern, String str) {
    String[] arr = str.split(" ");
    if (arr.length != pattern.length()) {
      return false;
    }
    HashMap<Character, String> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      char c = pattern.charAt(i);
      if (map.containsKey(c)) {
        if (map.get(c).equals(arr[i])) {
          continue;
        } else {
          return false;
        }
      } else {
        if (!map.containsValue(arr[i])) {
          map.put(c, arr[i]);
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    String pattern = "abba";
//    String str = "dog cat cat dog";
    String pattern = "abba";
    String str = "dog dog dog dog";
    System.out.println(wordPattern(pattern, str));
  }
}
