package com.stackoverflow.arrayShift;

import java.util.Arrays;

/**
 *
 */

/**
 * @author MelikeErcan
 *
 */
public class ArrayShift {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(input));

        int[] temp = new int[input.length * 2];

        int tempIndex = 0;
        for (int i = 0; i < 2; i++) {
            for (int element : input) {
                temp[tempIndex++] = element;
            }
        }

        System.out.println(Arrays.toString(temp));
        tempIndex = 0;
        for (int i = input.length - 1; i < temp.length - 1; i++) {
            input[tempIndex++] = temp[i];
        }

        System.out.println(Arrays.toString(input));
    }

}
