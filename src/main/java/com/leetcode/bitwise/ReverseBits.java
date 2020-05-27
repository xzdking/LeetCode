package com.leetcode.bitwise;

public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((res & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return 0;
    }


}
