package com.leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * <p>
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     * <p>
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     *
     * @param array1
     * @param m
     * @param array2
     * @param n
     * @return
     */
    public static int[] mergeSortedArray(int[] array1, int m, int[] array2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            array1[k--] = array1[i] >= array2[j] ? array1[i--] : array2[j--];
        }
        while (j >= 0) {
            array1[k--] = array2[j--];
        }
        return array1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] arr2 = new int[]{2, 5, 6};
        System.out.println(Arrays.toString(mergeSortedArray(arr1, 3, arr2, 3)));
    }

}
