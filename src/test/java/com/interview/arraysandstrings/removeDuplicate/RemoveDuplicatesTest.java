/**
 *
 */
package com.interview.arraysandstrings.removeDuplicate;

import org.junit.Test;

/**
 * @author MelikeErcan
 *
 */
public class RemoveDuplicatesTest {

    @SuppressWarnings("deprecation")
    @Test
    public void test() {
        String nullStr = "";
        String strLength1 = "a";
        String strNoDuplicate = "abcd";
        String strAllDuplicate = "aaaa";
        String strDuplicate1 = "ababab";
        String strDuplicate2 = "abcab";
        String nullStrResult = RemoveDuplicates.removeDuplicates(nullStr);
        String strLength1Result = RemoveDuplicates.removeDuplicates(strLength1);
        String strNoDuplicateResult = RemoveDuplicates.removeDuplicates(strNoDuplicate);
        String strAllDuplicateResult = RemoveDuplicates.removeDuplicates(strAllDuplicate);
        String strDuplicate1Result = RemoveDuplicates.removeDuplicates(strDuplicate1);
        String strDuplicate2Result = RemoveDuplicates.removeDuplicates(strDuplicate2);
        assert (nullStr.equals(nullStrResult));
        assert (strLength1.equals(strLength1Result));
        assert (strNoDuplicate.equals(strNoDuplicateResult));
        assert (strAllDuplicateResult.equals("a"));
        assert (strDuplicate1Result.equals("ab"));
        assert (strDuplicate2Result.equals("abc"));
    }

}
