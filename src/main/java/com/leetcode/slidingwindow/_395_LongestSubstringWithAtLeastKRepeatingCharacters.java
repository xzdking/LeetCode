package com.leetcode.slidingwindow;

public class _395_LongestSubstringWithAtLeastKRepeatingCharacters {

  /**
   * 395. 至少有K个重复字符的最长子串
   *
   * <p>找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
   *
   * <p>示例 1:
   *
   * <p>输入: s = "aaabb", k = 3
   *
   * <p>输出: 3
   *
   * <p>最长子串为 "aaa" ，其中 'a' 重复了 3 次。
   *
   * <p>示例 2:
   *
   * <p>输入: s = "ababbc", k = 2
   *
   * <p>输出: 5
   *
   * <p>最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
   *
   * @param s
   * @param k
   * @return
   */
  public static int longestSubstringWithAtLeastKRepeatingCharacters(String s, int k) {
    int res = 0;
    for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
      res = Math.max(res, helper(s, k, numUniqueTarget));
    }
    return res;
  }

  private static int helper(String s, int k, int numUniqueTarget) {
    int[] count = new int[128];
    int start = 0, end = 0;
    int numUnique = 0, numNoLessThanK = 0;
    int res = 0;
    while (end < s.length()) {
      if (count[s.charAt(end)]++ == 0) {
        numUnique++;
      }
      if (count[s.charAt(end++)] == k) {
        numNoLessThanK++;
      }
      while (numUnique > numUniqueTarget) {
        if (count[s.charAt(start)]-- == k) {
          numNoLessThanK--;
        }
        if (count[s.charAt(start++)] == 0) {
          numUnique--;
        }
      }
      if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
        res = Math.max(end - start, res);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "ababbc";
    int k = 2;
    System.out.println(longestSubstringWithAtLeastKRepeatingCharacters(s, k));
  }
}
