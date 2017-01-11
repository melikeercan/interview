/**
 *
 */
package com.interview.arraysandstrings.removeDuplicate;

import org.apache.commons.lang3.StringUtils;

import com.interview.utils.Generator;

/**
 * @author MelikeErcan
 *
 */
public class RemoveDuplicates {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // String str = "aabab";
        String str = Generator.getSaltString();
        System.out.println("String to Remove Duplicates: " + str);
        String result = removeDuplicates(str);
        System.out.println(result);

        String strReplace = Generator.getSaltString();
        System.out.println("String to Remove Duplicates with Replace: " + strReplace);
        String resultReplace = removeDuplicatesWithReplace(strReplace);
        System.out.println(resultReplace);

        String strBoolean = Generator.getSaltString();
        System.out.println("String to Remove Duplicates with Boolean: " + strBoolean);
        String resultBoolean = removeDuplicatesWithBoolean(strBoolean).trim();
        System.out.println(resultBoolean);

    }

    public static String removeDuplicates(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        for (char c : str.toCharArray()) {
            int cIndex = str.indexOf(c);
            if (cIndex != str.lastIndexOf(c)) {
                str = str.substring(0, cIndex) + str.substring(cIndex + 1);
            }
        }
        return str;
    }

    public static String removeDuplicatesWithReplace(String str) {
        for (char c : str.toCharArray()) {
            int cIndex = str.indexOf(c);
            if (cIndex != str.lastIndexOf(c)) {
                str = str.replaceAll("" + c, "") + c;
                System.out.println("new str: " + str);
            }
        }
        return str;
    }

    public static String removeDuplicatesWithBoolean(String str) {
        if (StringUtils.isEmpty(str) || str.length() < 2) {
            return str;
        }

        boolean[] hit = new boolean[256];
        for (int i = 0; i < 256; i++) {
            hit[i] = false;
        }
        char[] strChar = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i);
            hit[ascii] = true;
        }
        strChar = new char[256];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (hit[i] == true) {
                strChar[index++] = (char) i;
            }

        }
        return new String(strChar);
    }

}
