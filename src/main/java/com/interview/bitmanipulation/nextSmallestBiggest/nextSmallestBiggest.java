package com.interview.bitmanipulation.nextSmallestBiggest;

public class nextSmallestBiggest {

    public static void main(String[] args) {
        Integer value = 4;
        Integer oneCount = countOne(value);
        System.out.println("oneCount: " + oneCount);
        for (int i = value + 1;; i++) {
            Integer count = countOne(i);
            if (count == oneCount) {
                System.out.println("next biggest: " + i);
                break;
            }
        }
        for (int i = value - 1;; i--) {
            Integer count = countOne(i);
            if (count == oneCount) {
                System.out.println("next smallest: " + i);
                break;
            }
        }
    }

    private static Integer countOne(Integer value) {
        Integer temp = value;
        StringBuilder binary = new StringBuilder();
        Integer oneCount = 0;
        while (value > 0) {
            int val = value % 2;
            if (val == 1) {
                oneCount++;
            }
            binary.append(value % 2);
            value = value / 2;
        }
        System.out.println(temp + " : " + binary + " -> " + oneCount);
        return oneCount;
    }

}
