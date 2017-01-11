/**
 *
 */
package com.interview.arraysandstrings;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * @author MelikeErcan
 *
 */
public class CheckIfStringUnique {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = getSaltString();
        System.out.println("Check if string is unique: " + str);
        boolean unique = isUnique(str);
        System.out.println(unique);
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
