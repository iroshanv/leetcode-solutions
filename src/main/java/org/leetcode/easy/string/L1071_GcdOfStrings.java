package org.leetcode.easy.string;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description
 *
 * Reference
 *  https://leetcode.com/problems/greatest-common-divisor-of-strings/editorial
 *
 *
 *  #Math #String #Companies
 */
public class L1071_GcdOfStrings {


    @Test
    @DisplayName("using brute force")
    public void gcdOfStringsTest(){
        System.out.println( gcdOfStrings("ABCABC", "ABC")  );   // ABC
        System.out.println( gcdOfStrings("ABABAB", "ABAB") );   // AB
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

        for (int i = Math.min(len1, len2);
             i >= 1 ;
             i--) {
            if (isValid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }

        return "";
    }
}
