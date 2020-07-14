package com.leetcode.bitwise;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

  /**
   * 78. 子集
   *
   * <p>给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
   *
   * <p>说明：解集不能包含重复的子集。
   *
   * <p>示例:
   *
   * <p>输入: nums = [1,2,3]
   *
   * <p>输出:
   *
   * <p>[
   *
   * <p>[3],
   *
   * <p>[1],
   *
   * <p>[2],
   *
   * <p>[1,2,3],
   *
   * <p>[1,3],
   *
   * <p>[2,3],
   *
   * <p>[1,2],
   *
   * <p>[]
   *
   * <p>]
   *
   * @param nums
   * @return
   */
  public static List<List<Integer>> subsets(int[] nums) {
    if (nums == null || nums.length == 0) {}
    List<List<Integer>> res = new ArrayList<>();
    helper(res, new ArrayList<>(), nums, 0);
    return res;
  }

  public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
    res.add(new ArrayList<>(list));
    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);
      helper(res, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3};
    System.out.println(subsets(nums));
  }
}
