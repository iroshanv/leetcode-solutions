package org.leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * #HashTable #String #SlidingWindow
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * https://www.youtube.com/watch?v=3IETreEybaA
 *
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * https://www.youtube.com/watch?v=3IETreEybaA
 */
public class L03_LongestSubstringWithoutRepeatingChar {


    @Test
    public void longestSubstringWithoutRepeatingChar_hashset() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int L = 0;
        int R = 0;
        int winSize = 0;

        HashSet<Character> hashSet = new HashSet<>();
        while (R < s.length()) {

            char ch = s.charAt(R);
            if (!hashSet.contains(ch)) {
                hashSet.add(ch);
                R++;
                winSize = Math.max(hashSet.size(), winSize);
            }else{
                hashSet.remove(s.charAt(L));
                L++;
            }

        }
        return winSize;
    }
}
