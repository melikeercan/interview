package com.interview.bitmanipulation.bitsRequired;

public class bitsRequired {

    public static void main(String[] args) {
        Integer firstVal = 31;
        Integer secondVal = 14;

        int bitsRequired = required(firstVal, secondVal);
        System.out.println("bits required: " + bitsRequired);
    }

    private static int required(Integer firstVal, Integer secondVal) {
        String binary1 = binary(firstVal);
        System.out.println(binary1);
        String binary2 = binary(secondVal);
        System.out.println(binary2);
        int diff = binary1.length() - binary2.length();
        if (diff == 0) {
            System.out.println("same length, no extra zeros");
        } else if (diff > 0) {
            while (diff > 0) {
                diff -= 1;
                binary2 = "0" + binary2;
            }
        } else {
            while (diff < 0) {
                diff += 1;
                binary1 = "0" + binary1;
            }
        }
        System.out.println("---------");
        System.out.println(binary1);
        System.out.println(binary2);

        String leftShift = binary1;
        String rightShift = binary1;

        int leftCounter = 0;
        while (!leftShift.equals(binary2)) {
            leftCounter++;
            leftShift = leftShift.substring(1) + "0";
            System.out.println(leftShift);
            if (leftCounter == binary2.length()) {
                break;
            }
        }
        System.out.println(leftCounter);

        int rightCounter = 0;
        while (!rightShift.equals(binary2)) {
            rightCounter++;
            rightShift = "0" + rightShift.substring(0, rightShift.length() - 1);
            System.out.println(rightShift);
            if (rightCounter == binary2.length()) {
                break;
            }
        }
        System.out.println(rightCounter);
        return Math.min(leftCounter, rightCounter);
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
