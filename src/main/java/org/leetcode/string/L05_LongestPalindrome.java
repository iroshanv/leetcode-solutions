package org.leetcode.string;

import org.junit.jupiter.api.Test;

/**
 * #String #DynamicProgramming
 * https://leetcode.com/problems/longest-palindromic-substring/
 * https://www.youtube.com/watch?v=XYQecbcd6_c => NeetCode
 * https://www.youtube.com/watch?v=y2BD4MJqV20 => NickWhite
 *
 *
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 */
public class L05_LongestPalindrome {


    @Test
    public void longestPalindromeTest() {
        System.out.println(longestPalindrome_BF("babad"));
        System.out.println(longestPalindrome_BF("cbbd"));
        System.out.println(longestPalindrome_BF("a"));
        System.out.println(longestPalindrome_BF("ab"));
        System.out.println(longestPalindrome_BF("aaa"));
    }


    // ------------
    // brute-force
    // -------------
    public String longestPalindrome_BF(String s) {

        if (s.length() == 1) return s;

        String longest = "";
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                final String subStr = s.substring(i,j);
                if (isPalindrome(subStr)) {
                    int max = Math.max(longest.length(), subStr.length());
                    if (max > longest.length()) {
                        longest = s.substring(i, j);
                    }
                }

            }
        }

        return longest;
    }

    private static boolean isPalindrome(String s) {
        int L = 0;
        int R = s.length() - 1;

        while (L <  R) {
            if (s.charAt(L) != s.charAt(R)) {
                return false;
            }

            L++;
            R--;
        }

        return true;
    }


}
