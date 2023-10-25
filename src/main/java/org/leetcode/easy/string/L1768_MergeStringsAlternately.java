package org.leetcode.easy.string;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately/" />
 * <a href="https://www.youtube.com/watch?v=LECWOvTo-Sc" />
 * #TwoPointer #String #Companies
 * #LeetCode75
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

        int i = 0, j = 0;
        while ( i < chars1.length && j < chars2.length ) {
            mergedString.append(chars1[i]);
            mergedString.append(chars2[j]);

            i++;
            j++;
        }

        if (i < chars1.length) {
            mergedString.append(word1.substring(i));
        }

        if (j < chars2.length) {
            mergedString.append(word2.substring(j));
        }

        return mergedString.toString();
    }
}
