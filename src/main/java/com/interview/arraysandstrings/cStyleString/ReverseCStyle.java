/**
 *
 */
package com.interview.arraysandstrings.cStyleString;

import com.interview.utils.Generator;

/**
 * @author MelikeErcan
 *
 */
public class ReverseCStyle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = Generator.getSaltString();
        System.out.println("C style string to reverse: " + str);
        reverse(str);
    }

    private static String reverse(String str) {
        str += '\0';
        int length = str.length();
        char[] chars = new char[length];
        int j = 0;
        for (int i = length - 1; i >= 0;) {
            chars[j++] = str.charAt(i--);
        }
        String resultStr = new String(chars);
        System.out.println("****" + resultStr + "********");
        return resultStr;
    }

}
