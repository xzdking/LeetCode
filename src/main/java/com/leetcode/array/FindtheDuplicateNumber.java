package com.leetcode.array;

public class FindtheDuplicateNumber {

    /**
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
     * Assume that there is only one duplicate number, find the duplicate one.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,3,4,2,2]
     * Output: 2
     * Example 2:
     * <p>
     * Input: [3,1,3,4,2]
     * Output: 3
     * Note:
     * <p>
     * You must not modify the array (assume the array is read only).
     * You must use only constant, O(1) extra space.
     * Your runtime complexity should be less than O(n2).
     * There is only one duplicate number in the array, but it could be repeated more than once.
     *
     * @param nums
     * @return
     */

    /**
     * 二分法解法 time: O(nlogn) space:O(1)
     */
    public static int findtheDuplicateNumber(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while (min < max) {
            int mid = max - min / 2 + min;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 4, 2};
        System.out.println(findtheDuplicateNumber(nums));
    }

}
