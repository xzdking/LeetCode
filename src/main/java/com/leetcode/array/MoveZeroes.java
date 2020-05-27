package com.leetcode.array;

import java.util.Arrays;

public class MoveZeroes {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Example:
     * <p>
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     * <p>
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */

    // 适用于 零 少的情况
    public static int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        while (start <= nums.length - 1) {
            nums[start++] = 0;
        }
        return nums;
    }

    /**
     * 实质：冒泡排序法
     * 适用于 零 多的情况
     */
    public static int[] moveZeroesBubble(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeroes(nums)));
        System.out.println(Arrays.toString(moveZeroesBubble(nums)));
    }

}
