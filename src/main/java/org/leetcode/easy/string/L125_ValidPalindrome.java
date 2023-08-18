package org.leetcode.easy.string;

import org.junit.jupiter.api.Test;

/**
 * #TwoPointers #String
 *
 *
 * https://leetcode.com/problems/valid-palindrome/
 * https://www.youtube.com/watch?v=rYyn9Vc-dBQ&t=252s
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0125-Valid-Palindrome/Animation/animation.gif
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class L125_ValidPalindrome {


    @Test
    void valid_palindrome_test() {
        System.out.println(isPalindrome("madam"));
    }

    public boolean isPalindrome(String s) {
        String phrase = "";
        for(char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                phrase += c;
            }
        }

        phrase = phrase.toLowerCase();
        int i = 0;
        int j = phrase.length() - 1;

        while ( i <= j) {
            if (phrase.charAt(i) != phrase.charAt(j)) {
                return  false;
            }
            i++;
            j--;
        }

        return true;
    }

}
