package com.leetcode.array;

import java.util.Arrays;

public class _274_HIndex {

    /**
     * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
     * <p>
     * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
     * <p>
     * Example:
     * <p>
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
     * received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining
     * two with no more than 3 citations each, her h-index is 3.
     * Note: If there are several possible values for h, the maximum one is taken as the h-index.
     *
     * @return
     */
    // time:O(nlogn) space: O(1)
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }
        return res;
    }

    // time: O(n) space:(n)
    public static int hIndexHelper(int[] citations) {
        int[] helper = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            // helper[Math.min(citations[i], citations.length)] += 1;
            helper[citations[i] <= citations.length ? citations[i] : citations.length] += 1;
        }
        int sum = 0;
        for (int i = citations.length; i > 0; i--) {
            sum += helper[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
