package com.leetcode.binarysearch;

public class SearchInsertPosition {

  /**
   * Given a sorted array and a target value, return the index if the target is found. If not,
   * return the index where it would be if it were inserted in order.
   *
   * <p>You may assume no duplicates in the array.
   *
   * <p>Example 1:
   *
   * <p>Input: [1,3,5,6], 5 Output: 2 Example 2:
   *
   * <p>Input: [1,3,5,6], 2 Output: 1 Example 3:
   *
   * <p>Input: [1,3,5,6], 7 Output: 4 Example 4:
   *
   * <p>Input: [1,3,5,6], 0 Output: 0
   *
   * @param nums
   * @param target
   * @return
   */
  public static int searchInsertPosition(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 3, 5, 6};
    System.out.println(searchInsertPosition(nums, 3));
  }
}
