package com.interview.bitmanipulation.decimalToBinary;

public class decimalToBinary {

    public static void main(String[] args) {
        double value = 0.72;
        String res = myPrinter(value);
        System.out.println(res);
        String result = printBinary("1.1");
        System.out.println(result);
    }

    private static String myPrinter(double value) {
        if (value >= 1 || value <= 0) {
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (value > 0) {
            if (binary.length() > 32) {
                return "ERROR";
            }
            double r = value * 2;
            if (r >= 1) {
                binary.append(1);
                value = r - 1;
            } else {
                binary.append(0);
                value = r;
            }
        }
        return binary.toString();
    }

    private static String printBinary(String n) {
        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decPart = Double.parseDouble(n.substring(n.indexOf('.')));
        String int_string = "";
        while (intPart > 0) {
            int r = intPart % 2;
            intPart >>= 1;
            int_string = r + int_string;
        }
        StringBuffer dec_string = new StringBuffer();
        while (decPart > 0) {
            if (dec_string.length() > 32) {
                return "ERROR";
            }
            if (decPart == 1) {
                dec_string.append((int) decPart);
                break;
            }
            double r = decPart * 2;
            if (r >= 1) {
                dec_string.append(1);
                decPart = r - 1;
            } else {
                dec_string.append(1);
                decPart = r;
            }
        }

        return int_string + "." + dec_string.toString();
    }

}
