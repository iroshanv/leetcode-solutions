package org.leetcode.easy.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * #Math
 *
 * Given an integer x, return true if x is a
 * palindrome and false otherwise.
 *
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 *
 * https://leetcode.com/problems/palindrome-number
 */
public class L09_PalindromeNumber {


    @Test
    @DisplayName("palindrome number using modulo and division operator")
    public void palindrome_using_modulo_division() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        final int actualNum = x;
        int rev = 0;
        while (x != 0) {
            final int rem = x % 10;
            x = x / 10;
            rev = rev * 10 + rem;
        }
        return (actualNum == rev);
    }
}
