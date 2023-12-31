package org.leetcode.easy.string;

import org.junit.jupiter.api.Test;

/**
 * #HashTable #String #Greedy
 *
 * https://leetcode.com/problems/longest-palindrome/
 * https://www.youtube.com/watch?v=a_3XDW9P47E => NickWhite
 *
 * Given a string `s` which consists of lowercase or uppercase letters,
 * `return the length` of the `longest palindrome that can be BUILT` with those letters.
 *
 * Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class L409_LongestPalindrome {


    @Test
    public void longestPalindrome_Test() {
        System.out.println("longest palindrome length = " + longestPalindrome("a"));
        System.out.println("longest palindrome length = " + longestPalindrome("bbbba"));
//        System.out.println("longest palindrome length = " + longestPalindrome("abccccdd"));
    }


    /**
     *  input = abccccdd
     *  char  count
     *  c    = 4
     *  d    = 2
     *  b    = 1
     *  a    = 1
     *
     *  For each letter, say it occurs `c` times. We know we have `c/2 * 2` letters that can be partnered for sure.
     *  For example, if we have 'aaaaa', then we could have 'aaaa' partnered, which is 5/2 * 2 = 4 letters partnered.
     *
     *  At the end, if there was any c % 2 == 1, then that letter could have been a unique center.
     *  Otherwise, every letter was partnered.
     *
     *  To perform this check, we will check for c % 2 == 1 and ans % 2 == 0,
     *  the latter meaning we haven't yet added a unique center to the answer.
     */
    public static int longestPalindrome(String s) {

        // character counts
        int[] counts = new int[128];
        for (char c: s.toCharArray()) {
            counts[c]++;
        }


        int result = 0;
        for(int count : counts) {

            // if we have 3 aaa,
            // 3 / 2 = 1 ch can be put in middle
            // 1 * 2 = 2 ch can be put into palindrome
            //
            // if we have 4 aaaa
            // 4 / 2 = 2
            // 2 * 2 = 4
            //
            // number of character which can be put into palindrome
            result += (count / 2) * 2;

            if (result % 2 == 0 && count % 2 == 1) {
                result += 1;
            }

        }

        return result;
    }
}
