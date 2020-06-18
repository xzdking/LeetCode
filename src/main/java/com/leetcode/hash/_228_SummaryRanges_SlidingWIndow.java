package com.leetcode.hash;

import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges_SlidingWIndow {

  /**
   * 228. 汇总区间 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
   *
   * <p>示例 1:
   *
   * <p>输入: [0,1,2,4,5,7] 输出: ["0->2","4->5","7"] 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
   *
   * <p>示例 2:
   *
   * <p>输入: [0,2,3,4,6,8,9] 输出: ["0","2->4","6","8->9"] 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
   *
   * @param nums
   * @return
   */
  public static List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<>();
    if (nums == null && nums.length == 0) {
      return res;
    }
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
        i++;
      }
      if (num != nums[i]) {
        res.add(num + "->" + nums[i]);
      } else {
        res.add(num + "");
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {0, 2, 3, 4, 6, 8, 9};
    System.out.println(summaryRanges(nums).toString());
  }
}
