package com.leetcode.bitwise;

public class Base7 {

    /**
     * 递归的方式
     *
     * @return
     */
    public static String base7Recursive(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = false;
        StringBuilder sb = new StringBuilder("");
        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num /= 7;
        }
        if (negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    /**
     * 迭代的方式
     *
     * @param num
     * @return
     */
    public static String base7Iterative(int num) {
        if (num < 0) {
            return "-" + base7Iterative(num);
        }
        if (num < 7) {
            return "" + num;
        }
        return base7Iterative(num / 7) + num % 7;
    }

    public static void main(String[] args) {
//        System.out.printf(base7Iterative(0));
        System.out.println(base7Recursive(8));
    }
}
