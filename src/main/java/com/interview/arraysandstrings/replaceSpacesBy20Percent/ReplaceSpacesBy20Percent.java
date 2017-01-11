/**
 *
 */
package com.interview.arraysandstrings.replaceSpacesBy20Percent;

import org.apache.commons.lang3.StringUtils;

/**
 * @author MelikeErcan
 *
 */
public class ReplaceSpacesBy20Percent {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = " melike ercan here ";
        System.out.println("Replace Spaces By 20 Percent: " + str);
        String afterReplaceOperation = applyReplaceOperation(str);
        System.out.println(afterReplaceOperation);

        String afterReplaceOperationWithCount = applyReplaceOperationWithCount(str);
        System.out.println(afterReplaceOperationWithCount);
    }

    /**
     * @param str
     * @return
     */
    private static String applyReplaceOperation(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String applyReplaceOperationWithCount(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] strChar = str.toCharArray();
        int length = strChar.length;
        int count = 0;
        for (char c : strChar) {
            if (c == ' ') {
                count++;
            }
        }

        if (count == 0) {
            return str;
        }

        char[] newChar = new char[length + (count * 2)];
        int index = 0;
        for (char c : strChar) {
            if (c != ' ') {
                newChar[index++] = c;
            } else {
                newChar[index++] = '%';
                newChar[index++] = '2';
                newChar[index++] = '0';
            }
        }
        return new String(newChar);
    }

}
