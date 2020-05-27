package com.leetcode.array;

public class IncreasingTripletSubsequence {

    /**
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
     * <p>
     * Formally the function should:
     * <p>
     * Return true if there exists i, j, k
     * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
     * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: true
     * Example 2:
     * <p>
     * Input: [5,4,3,2,1]
     * Output: false
     *
     * @param nums
     * @return
     */

    public static boolean increasingTripletSubsequence(int[] nums) {
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num < secMin) {
                secMin = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(increasingTripletSubsequence(nums));
    }

}
