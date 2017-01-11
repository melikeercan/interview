/**
 *
 */
package com.interview.arraysandstrings.anagrams;

import org.apache.commons.lang3.StringUtils;

/**
 * @author MelikeErcan
 *
 */
public class CheckIfAnagrams {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // String str = "aabab";
        String firstStr = "LISTEN";
        String secondStr = "SILENE";

        boolean isAnagram = checkIfAnagrams(firstStr, secondStr);
        System.out.println(isAnagram);
    }

    /**
     * @param firstStr
     * @param secondStr
     * @return
     */
    private static boolean checkIfAnagrams(String firstStr, String secondStr) {
        if (StringUtils.isEmpty(firstStr) && StringUtils.isEmpty(secondStr)) {
            return true;
        }
        if ((StringUtils.isEmpty(firstStr) && !StringUtils.isEmpty(secondStr))
                || (StringUtils.isEmpty(secondStr) && !StringUtils.isEmpty(firstStr))) {
            return false;
        }

        if (firstStr.length() != secondStr.length()) {
            return false;
        }

        return compare(firstStr, secondStr);
    }

    /**
     * @param firstStr
     * @param secondStr
     * @return
     */
    private static boolean compare(String firstStr, String secondStr) {
        int[] hitFirst = new int[256];
        for (int i = 0; i < 256; i++) {
            hitFirst[i] = 0;
        }

        int[] hitSecond = new int[256];
        for (int i = 0; i < 256; i++) {
            hitSecond[i] = 0;
        }

        for (int i = 0; i < firstStr.length(); i++) {
            int ascii = firstStr.charAt(i);
            hitFirst[ascii] += 1;
        }

        for (int i = 0; i < secondStr.length(); i++) {
            int ascii = secondStr.charAt(i);
            hitSecond[ascii] += 1;
        }

        for (int i = 0; i < 256; i++) {
            if (hitFirst[i] != hitSecond[i]) {
                System.out.println((char) i);
                return false;
            }
        }

        return true;
    }

}
