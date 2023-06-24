package org.leetcode.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * #Math
 *
 *  https://leetcode.com/problems/reverse-integer/
 *
 *  Given a signed 32-bit integer x, return x with its digits reversed.
 *  If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 *  Input: x = 123
 *  Output: 321
 *
 */
public class L07_ReverseInteger {

    @Test
    @DisplayName("reverse integer using modulo and division operator")
    public void reversInteger_modulo_division() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));

        //intMax = 2147483647
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(1534236469));

        // test case for pop > 7
        System.out.println(reverse(1463847412));
    }

    // Approach: Pop and Push Digits & Check before Overflow
    // temp=rev⋅10+pop can cause overflow.
    // To explain, lets assume that rev is positive.
    //  1. if temp = rev * 10 causes overflow, then it must be that rev >= INTMAX/10
    //  2. if rev > INTMAX/10,  then temp = rev * 10 + pop is guaranteed to overflow
    //  3. if rev == INTMAX/10, then temp = rev * 10 + pop will overflow if and only if pop > 7

    public static final int intMaxDiv10 = Integer.MAX_VALUE / 10;
    public static final int intMinDiv10 = Integer.MIN_VALUE / 10;
    public static int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            // pop operation
            final int pop = x % 10;
            x = x / 10;

            if(rev > intMaxDiv10 || (rev == intMaxDiv10 && pop > 7)) return 0;
            if(rev < intMinDiv10 || (rev == intMinDiv10 && pop < -8)) return 0;

            // push operation
            rev = rev * 10 + pop;
        }
        return rev;
    }
}