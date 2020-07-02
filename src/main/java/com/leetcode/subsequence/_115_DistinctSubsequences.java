package com.leetcode.subsequence;

public class _115_DistinctSubsequences {

  /**
   * 115. 不同的子序列
   *
   * <p>给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
   *
   * <p>一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
   *
   * <p>题目数据保证答案符合 32 位带符号整数范围。
   *
   * <p>示例 1：
   *
   * <p>输入：S = "rabbbit", T = "rabbit" 输出：3
   *
   * <p>解释：
   *
   * <p>如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。 (上箭头符号 ^ 表示选取的字母)
   *
   * <p>rabbbit
   *
   * <p>^^^^ ^^
   *
   * <p>rabbbit
   *
   * <p>^^ ^^^^
   *
   * <p>rabbbit
   *
   * <p>^^^ ^^^
   *
   * <p>示例 2：
   *
   * <p>输入：S = "babgbag", T = "bag" 输出：5
   *
   * <p>解释：
   *
   * <p>如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 (上箭头符号 ^ 表示选取的字母)
   *
   * <p>babgbag
   *
   * <p>^^ ^
   *
   * <p>babgbag
   *
   * <p>^^ ^
   *
   * <p>babgbag
   *
   * <p>^ ^^
   *
   * <p>babgbag
   *
   * <p>^ ^^
   *
   * <p>babgbag
   *
   * <p>^^^
   *
   * @param s
   * @param t
   * @return
   */
  public static int distinctSubsequences(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i < s.length(); i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[s.length()][t.length()];
  }

  public static void main(String[] args) {
    String s = "babgbag";
    String t = "bag";
    System.out.println(distinctSubsequences(s, t));
  }
}
