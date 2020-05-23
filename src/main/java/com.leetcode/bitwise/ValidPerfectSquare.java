package com.leetcode.bitwise;

/**
 * 367. Valid Perfect Square
 */
public class ValidPerfectSquare {

    /**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     * <p>
     * Follow up: Do not use any built-in library function such as sqrt.
     * <p>
     * Example 1:
     * <p>
     * Input: num = 16
     * Output: true
     * Example 2:
     * <p>
     * Input: num = 14
     * Output: false
     * <p>
     * Constraints: 1 <= num <= 2^31 - 1
     * <p>
     * 1、暴力解
     * 2、找规律
     * 3、二分法
     * 4、牛顿法
     */
    public static boolean validPerfectSquareWithBrute(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        //  num/i 省略部分数字的循环  提高效率
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1:1
     * 4:1+3
     * 9:1+3+5
     * 16:1+3+5+7
     */
    public static boolean validPerfectSquareWithRegular(int num) {
        int i = 0;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * 二分法
     * time O(logn) space O(1)
     */
    public static boolean validPerfectSquareWithDichotomy(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) (mid + 1);
            } else {
                high = (int) (mid - 1);
            }
        }
        return false;
    }

    /**
     * 牛顿法解释
     * https://www.zhihu.com/question/20690553/answer/146104283
     */
    public static boolean validPerfectSquareWithNewtonMethod(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    public static void main(String[] args) {
        System.out.println(validPerfectSquareWithBrute(8));
        System.out.println(validPerfectSquareWithRegular(8));
        System.out.println(validPerfectSquareWithDichotomy(8));
        System.out.println(validPerfectSquareWithNewtonMethod(8));

    }

}
