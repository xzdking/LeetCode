package com.leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {

  /**
   * 46. 全排列
   *
   * <p>给定一个 没有重复 数字的序列，返回其所有可能的全排列。
   *
   * <p>示例:
   *
   * <p>输入: [1,2,3]
   *
   * <p>输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
   *
   * @param nums
   * @return
   */
  public static List<List<Integer>> permutations(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    helper(res, new ArrayList<>(), nums);
    return res;
  }

  public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
    if (list.size() == nums.length) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (list.contains(nums[i])) {
        continue;
      }
      list.add(nums[i]);
      helper(res, list, nums);
      list.remove(list.size() - 1);
    }
  }

  public static List<List<Integer>> permutationsWithSwap(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    helper2(res, 0, nums);
    return res;
  }

  public static void helper2(List<List<Integer>> res, int start, int[] nums) {
    if (start == nums.length) {
      List<Integer> list = new ArrayList<>();
      for (int num : nums) {
        list.add(num);
      }
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < nums.length; i++) {
      swap(nums, start, i);
      helper2(res, start + 1, nums);
      swap(nums, start, i);
    }
  }

  public static void swap(int[] nums, int l, int r) {
    int temp = nums[l];
    nums[l] = nums[r];
    nums[r] = temp;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3};
    System.out.println(permutations(nums));
    System.out.println(permutationsWithSwap(nums));
  }
}
