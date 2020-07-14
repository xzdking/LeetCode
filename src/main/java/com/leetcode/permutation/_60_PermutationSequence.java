package com.leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

public class _60_PermutationSequence {

  /**
   * 60. 第k个排列
   *
   * <p>给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
   *
   * <p>按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
   *
   * <p>"123" "132" "213" "231" "312" "321" 给定 n 和 k，返回第 k 个排列。
   *
   * <p>说明：
   *
   * <p>给定 n 的范围是 [1, 9]。 给定 k 的范围是[1, n!]。
   *
   * <p>示例 1:
   *
   * <p>输入: n = 3, k = 3 输出: "213"
   *
   * <p>示例 2:
   *
   * <p>输入: n = 4, k = 9 输出: "2314"
   *
   * @param n
   * @param k
   * @return
   */
  public static String permutationSequence(int n, int k) {
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      res.add(i);
    }
    int[] fact = new int[n];
    fact[0] = 1;
    for (int i = 1; i < n; i++) {
      fact[i] = i * fact[i - 1];
    }
    k = k - 1;
    StringBuilder sb = new StringBuilder();
    for (int i = n; i > 0; i--) {
      int index = k / fact[i - 1];
      k = k % fact[i - 1];
      sb.append(res.get(index));
      res.remove(index);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int n = 3;
    int k = 3;
    System.out.println(permutationSequence(n, k));
  }
}
