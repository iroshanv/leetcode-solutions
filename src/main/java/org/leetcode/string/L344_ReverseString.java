package org.leetcode.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * #TwoPointers #String
 *
 * https://leetcode.com/problems/reverse-string/
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0344-Reverse-String/Animation/Animation.gif
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * https://en.wikipedia.org/wiki/In-place_algorithm
 *
 * https://www.youtube.com/watch?v=NA--2JiDaeQ
 */
public class L344_ReverseString {


    @Test
    @DisplayName("ReverseString using Lib")
    public void reverseString_lib() {
        reverseString_lib( new char[]{'h', 'e', '*', 'l', 'o'});
        reverseString_lib(new char[]{'h', 'a', 'n', '*', 'a', 'H'});
        reverseString_lib(new char[]{'t', 'a', 'n', '*', 'y', 'a'});
    }

    @Test
    @DisplayName("ReverseString using swap")
    public void reverseString_swap() {
        reverseString_swap(new char[]{'h', 'e', '*', 'l', 'o'});
        reverseString_swap(new char[]{'h', 'a', 'n', '*', 'a', 'H'});
        reverseString_swap(new char[]{'t', 'a', 'n', '*', 'y', 'a'});
    }

    @Test
    @DisplayName("ReversString brute force")
    public void reverseString_brute_force() {
        reverseString_bruteForce(new char[]{'h', 'e', '*', 'l', 'o'});
        reverseString_bruteForce(new char[]{'h', 'a', 'n', '*', 'a', 'H'});
        reverseString_bruteForce(new char[]{'t', 'a', 'n', '*', 'y', 'a'});
    }

    public static void reverseString_lib(char[] s) {
        String revStr = new StringBuilder(String.copyValueOf(s)).reverse().toString();
        System.out.println(revStr);
    }

    public static void reverseString_bruteForce(char[] s) {
        final int length = s.length;
        String[] rev = new String[length];
        for (int i = 0; i < length; i++) {
            rev[i] = String.valueOf(s[length - i - 1]);
        }
        System.out.println(Arrays.toString(rev));
    }

    public static void reverseString_swap(char[] s) {
        for (int i = 0, j = s.length - 1;
             i < j;
             i++, j--) {

            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

        }
        System.out.println(Arrays.toString(s));
    }
}

//    public static void reverseString_array_usingSwap(char[] s){
//        int length = s.length;
//        int mid = (s.length % 2 == 0) ?  (s.length / 2) - 1 : s.length/2;
//        for (int i = 0; i <=mid; i++) {
//            char temp = s[i];
//            s[i] = s[length-i-1];
//            s[length-i-1] = temp;
//        }
//        System.out.println(Arrays.toString(s));
//    }




