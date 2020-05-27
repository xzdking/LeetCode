package com.leetcode.bitwise;

public class AddBinary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     * The input strings are both non-empty and contains only characters 1 or 0.
     * <p>
     * Example
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     * <p>
     * Constraints:
     * Each string consists only of '0' or '1' characters.
     * 1 <= a.length, b.length <= 10^4
     * Each string is either "0" or doesn't contain any leading zero.
     *
     * @param a
     * @param b
     * @return
     */

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;
        while (i >= 0 && j > 0) {
            int sum = remainder;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            sb.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder != 0) {
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
//        String str = "012";
//        System.out.println(str.charAt(2));
//        System.out.println(str.charAt(2) - 'a');
//        System.out.println(str.charAt(2) - '0');

        String x = "11";
        String y = "1";
        System.out.println(addBinary(x, y));
    }

}
