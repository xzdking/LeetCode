package com.leetcode.bitwise;

public class AddDigits {


    /**
     * 258. Add Digits
     * <p>
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * <p>
     * Example:
     * <p>
     * Input: 38
     * Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
     * Since 2 has only one digit, return it.
     *
     * @param num
     * @return
     */
    public static int addDigitsRecursive(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        if (sum > 10) {
            return addDigitsRecursive(sum);
        } else {
            return sum;
        }
    }

    public static int addDigitsRegular(int num) {
        return (num - 1) % 9 + 1;
    }


    public static void main(String[] args) {
        int x = 1229;
        System.out.println(addDigitsRecursive(x));
        System.out.println(addDigitsRegular(x));
    }

}
