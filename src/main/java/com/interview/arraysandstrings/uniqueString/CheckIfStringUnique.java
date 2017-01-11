/**
 *
 */
package com.interview.arraysandstrings.uniqueString;

import org.apache.commons.lang3.StringUtils;

import com.interview.utils.Generator;

/**
 * @author MelikeErcan
 *
 */
public class CheckIfStringUnique {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = Generator.getSaltString();
        System.out.println("Check if string is unique: " + str);
        boolean unique = isUnique(str);
        System.out.println(unique);

        boolean isUnique = checkForUnique(str);
        System.out.println(isUnique);
    }

    private static boolean isUnique(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        } else {
            String beginning = str.substring(0, str.length() - 1);
            String last = str.substring(str.length() - 1);
            return !isFound(beginning, last);
        }
    }

    private static boolean isFound(String beginning, String last) {
        System.out.println("beginning: " + beginning);
        System.out.println("last: " + last);
        if (StringUtils.isEmpty(last)) {
            return false;
        }

        if (beginning.length() == 1) {
            return last.equals(beginning);
        }

        for (int i = 0; i < beginning.length(); i++) {
            if (last.equals(beginning.substring(i, i + 1))) {
                return true;
            }
        }
        return isFound(beginning.substring(0, beginning.length() - 1), beginning.substring(beginning.length() - 1));
    }

    public static boolean checkForUnique(String str) {
        boolean hasUnique = false;

        for (char c : str.toCharArray()) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                hasUnique = true;
            } else {
                hasUnique = false;
            }
        }

        return hasUnique;
    }
}
