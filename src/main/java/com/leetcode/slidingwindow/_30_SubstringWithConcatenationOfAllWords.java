package com.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _30_SubstringWithConcatenationOfAllWords {

  /**
   * 30. 串联所有单词的子串 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
   *
   * <p>注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
   *
   * <p>示例 1：
   *
   * <p>输入： s = "barfoothefoobarman", words = ["foo","bar"] 输出：[0,9] 解释： 从索引 0 和 9 开始的子串分别是 "barfoo"
   * 和 "foobar" 。 输出的顺序不重要, [9,0] 也是有效答案。 示例 2：
   *
   * <p>输入： s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"] 输出：[]
   */
  public static List<Integer> substringWithConcatenationOfAllWords(String s, String[] words) {
    if (s == null || words == null || words.length == 0) {
      return new ArrayList<>();
    }
    List<Integer> res = new ArrayList<>();
    int n = words.length;
    int m = words[0].length();
    HashMap<String, Integer> map = new HashMap<>();

    for (String str : words) {
      map.put(str, map.getOrDefault(str, 0) + 1);
    }

    for (int i = 0; i <= s.length() - n * m; i++) {
      HashMap<String, Integer> copy = new HashMap<>(map);
      int k = n;
      int j = i;
      while (k > 0) {
        String str = s.substring(j, j + m);
        if (!copy.containsKey(str) || copy.get(str) < 1) {
          break;
        }
        copy.put(str, copy.get(str) - 1);
        k--;
        j += m;
      }
      if (k == 0) {
        res.add(i);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    //    String s = "barfoothefoobarman";
    //    String[] words = new String[] {"foo", "bar"};
    String s = "wordgoodgoodgoodbestword";
    String[] words = new String[] {"word", "good", "best", "word"};
    System.out.println(substringWithConcatenationOfAllWords(s, words));
  }
}
