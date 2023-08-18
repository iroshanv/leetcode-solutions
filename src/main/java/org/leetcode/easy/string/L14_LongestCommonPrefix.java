package org.leetcode.easy.string;

import org.junit.jupiter.api.Test;

/**
 * #String #Trie
 *
 * https://leetcode.com/problems/longest-common-prefix/
 * https://www.youtube.com/watch?v=bl8ue-dTxgs.s0 => NickWhite
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *

 */
public class L14_LongestCommonPrefix {

    @Test
    public void longest_common_prefix_test() {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] str) {
        if (str.length == 0) return "";

        // assume first string is the largest prefix
        String prefix = str[0];

        for (int i = 1; i < str.length; i++) {

            while (str[i].indexOf(prefix) != 0) {
                // decrement by 1 till we find a prefix
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}
