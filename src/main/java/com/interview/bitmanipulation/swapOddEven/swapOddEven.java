package com.interview.bitmanipulation.swapOddEven;

public class swapOddEven {

    public static void main(String[] args) {
        Integer swapThis = swap(33);
        System.out.println(swapThis);
        String binary = binary(33);
        String binary2 = binary(swapThis);
        System.out.println(binary);
        System.out.println(binary2);
    }

    private static Integer swap(int i) {
        // TODO Auto-generated method stub
        return ((i & 0xaaaaaaaa) >> 1) | ((i & 0x55555555) << 1);
    }

    private static String binary(Integer value) {
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
        return binary.toString();
    }
}
