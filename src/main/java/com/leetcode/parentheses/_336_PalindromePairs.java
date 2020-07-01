package com.leetcode.parentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _336_PalindromePairs {

  /**
   * 336. 回文对
   *
   * <p>给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
   *
   * <p>示例 1:
   *
   * <p>输入: ["abcd","dcba","lls","s","sssll"]
   *
   * <p>输出: [[0,1],[1,0],[3,2],[2,4]]
   *
   * <p>解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
   *
   * <p>示例 2:
   *
   * <p>输入: ["bat","tab","cat"]
   *
   * <p>输出: [[0,1],[1,0]]
   *
   * <p>解释: 可拼接成的回文串为 ["battab","tabbat"]
   */
  public static List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();
    if (words == null || words.length < 2) {
      return res;
    }
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.put(words[i], i);
    }
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j <= words[i].length(); j++) {
        String str1 = words[i].substring(0, j);
        String str2 = words[i].substring(j);
        if (isPalindrome(str1)) {
          String str2rvs = new StringBuilder(str2).reverse().toString();
          if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
            res.add(Arrays.asList(map.get(str2rvs), i));
          }
        }
        if (str2.length() != 0 && isPalindrome(str2)) {
          String str1vs = new StringBuilder(str1).reverse().toString();
          if (map.containsKey(str1vs) && map.get(str1vs) != i) {
            res.add(Arrays.asList(i, map.get(str1vs)));
          }
        }
      }
    }
    return res;
  }

  public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    String[] words = new String[] {"abcd","dcba","lls","s","sssll"};
    System.out.println(palindromePairs(words));
  }
}
