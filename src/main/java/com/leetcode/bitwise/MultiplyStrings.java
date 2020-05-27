package com.leetcode.bitwise;

public class MultiplyStrings {

    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
     * <p>
     * Example 1:
     * <p>
     * Input: num1 = "2", num2 = "3"
     * Output: "6"
     * Example 2:
     * <p>
     * Input: num1 = "123", num2 = "456"
     * Output: "56088"
     * Note:
     * <p>
     * The length of both num1 and num2 is < 110.
     * Both num1 and num2 contain only digits 0-9.
     * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     *
     * @param a
     * @param b
     * @return
     */
    public static String multiplyStrings(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }
        int[] digits = new int[a.length() + b.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int product = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int digit : digits) {
            if (!(digit == 0 && res.length() == 0)) {
                res.append(digit);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }


    public static void main(String[] args) {
        System.out.println(multiplyStrings("222", "16"));
    }


}
