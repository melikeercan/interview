/**
 *
 */
package com.interview.arraysandstrings;

import java.util.HashMap;
import java.util.Random;

/**
 * @author MelikeErcan
 *
 */
public class CheckIfStringUniqueWithDataStructures {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = getSaltString();
        System.out.println("Check if string is unique: " + str);
        boolean isUnique = isUnique(str);
        System.out.println(isUnique);
    }

    private static boolean isUnique(String str) {
        if (str == null) {
            return true;
        }
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        for (char c : str.toCharArray()) {
            if (hmap.get(c) == null) {
                hmap.put(c, 1);
            } else {
                return false;
            }
        }
        return true;
    }

    protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
