/**
 *
 */
package com.interview.arraysandstrings.subString;

import org.apache.commons.lang3.StringUtils;

import com.interview.utils.Generator;

/**
 * @author MelikeErcan
 *
 */
public class CheckIfSubstring {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        boolean result = checkIfSubstring(str1, str2);
        System.out.println(result);
    }

	private static boolean checkIfSubstring(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		if(str1.length() < 1) {
			return false;
		}
		String duplicate = str2 + str2;
		return isSubString(str1, duplicate);
	}

	private static boolean isSubString(String str1, String duplicate) {
		char[] duplicateChars = duplicate.toCharArray();
		char[] str1Chars = str1.toCharArray();
		if(duplicateChars.length < str1Chars.length) {
			return false;
		}
		
		return subString(duplicate, str1);
	}

	private static boolean subString(String duplicate, String str1) {
		// TODO Auto-generated method stub
		return true;
	}

    
}
