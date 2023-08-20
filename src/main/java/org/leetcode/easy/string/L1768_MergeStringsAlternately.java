package org.leetcode.easy.string;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/merge-strings-alternately/
 *
 * https://www.youtube.com/watch?v=LECWOvTo-Sc => NeetCode
 *
 *
 * #TwoPointer #String #Companies
 */
public class L1768_MergeStringsAlternately {


    @Test
    public void mergeAlternatelyTest(){
        System.out.println( mergeAlternately("abcd", "pq") );
        System.out.println( mergeAlternately("ab", "pqrs") );
        System.out.println( mergeAlternately("abc", "pqr") );
    }

    public static String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        StringBuilder mergedString = new StringBuilder(chars1.length + chars2.length);


        int X = 0, Y = 0;
        while ( X < chars1.length && Y < chars2.length) {
            mergedString.append(chars1[X]);
            mergedString.append(chars2[Y]);

            X++;
            Y++;
        }

        if (X < chars1.length) {
            mergedString.append(word1.substring(X));
        }

        if (Y < chars2.length) {
            mergedString.append(word2.substring(Y));
        }

        return mergedString.toString();
    }
}
