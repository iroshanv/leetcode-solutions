package org.leetcode.easy.string;

import org.junit.jupiter.api.Test;

/**
 * #HashTable #String #Sorting
 *
 * https://leetcode.com/problems/valid-anagram/
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0242-Valid-Anagram/Animation/242.gif
 * https://www.youtube.com/watch?v=IRN1VcA8CGc
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * rearrangement of letters
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 */
public class L242_ValidAnagram {
    @Test
    public void valid_anagram() {
        System.out.println(isAnagram("car","rat"));
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("tanagram","fnagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // count no of occurrence of each character
        int[] char_counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // increment and decrement at index level
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }

        for(int count : char_counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

}
