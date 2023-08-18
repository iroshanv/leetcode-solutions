package org.leetcode.easy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * #String #TwoPointers #StringMatching
 *
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class L28_FirstOccurrenceInString {

    @Test
    @DisplayName("using sliding window")
    public void firstOccurrenceInString_slidingWindow() {

        System.out.println(strStr_slidingWindow("abc", "c"));
        System.out.println(strStr_slidingWindow("a", "a"));

        //0
        System.out.println(strStr_slidingWindow("sadbutsad", "sad"));

        //3
        System.out.println(strStr_slidingWindow("sadbutsad", "but"));

        //-1
        System.out.println(strStr_slidingWindow("leetcode", "leeto"));

        //5
        System.out.println(strStr_slidingWindow("tanayroshan", "ros"));
    }

    private static int strStr_slidingWindow(String haystack, String needle) {

        if (haystack.length() == 1) return 0;

        int winSize = needle.length();

        for (int L = 0, R = winSize;
             R <= haystack.length();
             L++, R++)
        {
            if (haystack.substring(L, R).equals(needle)) {
                return L;
            }
        }

        return -1;
    }

    @Test
    @DisplayName("using a lib")
    public void firstOccurrenceInString_lib() {
        //0
        System.out.println(strStr_lib("sadbutsad", "sad"));

        //3
        System.out.println(strStr_lib("sadbutsad", "but"));

        //-1
        System.out.println(strStr_lib("leetcode", "leeto"));

        //5
        System.out.println(strStr_lib("tanayroshan", "ros"));
    }

    private static int strStr_lib(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
