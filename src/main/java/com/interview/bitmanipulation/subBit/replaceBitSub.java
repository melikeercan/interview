package com.interview.bitmanipulation.subBit;

public class replaceBitSub {

    public static void main(String[] args) {
        int n = 1024;
        System.out.println("n:" + n + " / " + Integer.toBinaryString(n));

        int m = 21;
        System.out.println("m:" + m + " / " + Integer.toBinaryString(m));

        int result = updateBits(n, m, 2, 6);
        System.out.println("result:" + result + " / " + Integer.toBinaryString(result));
    }

    private static int updateBits(int n, int m, int i, int j) {
        int max = ~0; /* All 1’s */
        System.out.println("max: " + max + " /   " + Integer.toBinaryString(max));
        // 1’s through position j, then 0’s
        System.out.println(Integer.toBinaryString((1 << j)));
        int left = max - ((1 << j) - 1);
        System.out.println("left: " + left + " / " + Integer.toBinaryString(left));
        // 1’s after position i
        System.out.println(Integer.toBinaryString((1 << i)));
        int right = ((1 << i) - 1);
        System.out.println("right: " + right + " / " + Integer.toBinaryString(right));
        // 1’s, with 0s between i and j
        int mask = left | right;
        System.out.println("mask: " + mask + " / " + Integer.toBinaryString(mask));
        // Clear i through j, then put m in there
        int res = (n & mask) | (m << i);
        return res;
    }
}
