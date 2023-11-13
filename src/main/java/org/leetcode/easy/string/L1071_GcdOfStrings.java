package org.leetcode.easy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/description" />
 * <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/editorial" />
 *  #Math #String #Companies
 *  #LeetCode75
 */
public class L1071_GcdOfStrings {

    // TODO: Approach 2

    @Test
    @DisplayName("using brute force")
    public void gcdOfStringsTest(){
        System.out.println( gcdOfStrings("ABABAB", "ABAB") );   // AB
        System.out.println( gcdOfStrings("ABCABC", "ABC")  );   // ABC
        System.out.println( gcdOfStrings("LEET", "CODE")   );   // ""
    }

    public boolean isValid(String str1, String str2, int k) {
        int length1 = str1.length();
        int length2 = str2.length();

        if (length1 % k > 0 || length2 % k > 0) {
            return false;
        } else {
            final String base = str1.substring(0, k);
            return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
        }
    }

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();

        // Find the shorter string among str1 and str2
        for (int i = Math.min(len1, len2);
             i >= 1 ;
             i--) {
            // find the `i = no-of-chars` that divides both string

            if (isValid(str1, str2, i)) {
                return str1.substring(0, i);
            }

        }

        return "";
    }
}
