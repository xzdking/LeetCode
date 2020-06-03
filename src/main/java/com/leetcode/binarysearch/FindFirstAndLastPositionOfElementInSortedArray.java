package com.leetcode.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

  /**
   * Given an array of integers nums sorted in ascending order, find the starting and ending
   * position of a given target value.
   *
   * <p>Your algorithm's runtime complexity must be in the order of O(log n).
   *
   * <p>If the target is not found in the array, return [-1, -1].
   *
   * <p>Example 1:
   *
   * <p>Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
   *
   * <p>Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[] {-1, 1};
    }
    int start = findStart(nums, target);
    if (start < -1) {
      return new int[] {-1, 1};
    }
    int end = findEnd(nums, target);
    return new int[] {start, end};
  }

  public static int findStart(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = (end - start) / 2 + start;
      if (nums[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (nums[start] == target) {
      return start;
    }
    if (nums[end] == target) {
      return end;
    }
    return -1;
  }

  public static int findEnd(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = (end - start) / 2 + start;
      if (nums[mid] > target) {
        end = mid;
      } else {
        start = mid;
      }
    }
    if (nums[end] == target) {
      return end;
    }
    if (nums[start] == target) {
      return start;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {5, 7, 7, 8, 8, 10};
    System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray(nums, 8)));
  }
}
