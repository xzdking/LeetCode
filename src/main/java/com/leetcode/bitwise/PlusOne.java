package com.leetcode.bitwise;

/**
 *
 * @author xuzhida
 */
public class PlusOne {

    public static int[] plus(int[] num) {
        if (num == null || num.length == 0) {
            return num;
        }
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] < 9) {
                num[i]++;
                return num;
            } else {
                num[i] = 0;
            }
        }
        int[] res = new int[num.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        System.out.println(plus(num));

        StringBuilder sb = new StringBuilder();
        sb.append("12");
        sb.append("34");
        System.out.println(sb.reverse());
    }
}
