package org.leetcode.easy.string;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/is-subsequence/
 * #TwoPointers #String #DynamicProgramming
 */
public class L392_IsSubsequence {

    @Test
    public void isSubSequenceTest(){
        System.out.println( isSubsequence("ace", "abcde")  );  // true
        System.out.println( isSubsequence("aec", "abcde")  );  // false
        System.out.println( isSubsequence("abc", "ahbgdc") );  // true
        System.out.println( isSubsequence("axc", "ahbgdc") );  // false
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while ( i < s.length() && j < t.length() ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                continue;
            }
            j++;
        }

        // check if `i` went out of bounds
        return (i == s.length());
    }
}
