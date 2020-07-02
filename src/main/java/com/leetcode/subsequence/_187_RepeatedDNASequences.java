package com.leetcode.subsequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _187_RepeatedDNASequences {

  /**
   * 187. 重复的DNA序列
   *
   * <p>所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，
   *
   * <p>例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
   *
   * <p>编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
   *
   * <p>示例：
   *
   * <p>输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
   *
   * <p>输出：["AAAAACCCCC", "CCCCCAAAAA"]
   *
   * @param s
   * @return
   */
  public static List<String> repeatedDNASequences(String s) {
    HashSet<String> seen = new HashSet<>();
    HashSet<String> repeated = new HashSet<>();
    for (int i = 0; i < s.length() - 9; i++) {
      String temp = s.substring(i, i + 10);
      if (!seen.add(temp)) {
        repeated.add(temp);
      }
    }
    return new ArrayList<>(repeated);
  }

  public static void main(String[] args) {
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    System.out.println(repeatedDNASequences(s));
  }
}
