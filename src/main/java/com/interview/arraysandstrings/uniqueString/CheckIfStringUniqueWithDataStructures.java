/**
 *
 */
package com.interview.arraysandstrings.uniqueString;

import java.util.HashMap;

import com.google.common.base.Strings;
import com.interview.utils.Generator;

/**
 * @author MelikeErcan
 *
 */
public class CheckIfStringUniqueWithDataStructures {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = Generator.getSaltString();
        System.out.println("Check if string is unique: " + str);
        boolean isUnique = isUnique(str);
        System.out.println(isUnique);
    }

    private static boolean isUnique(String str) {
        if (Strings.isNullOrEmpty(str)) {
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

}
