package org.leetcode.medium.string;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class L151_ReverseWordsInString {


    @Test
    public void reverseWordsInStringTest(){
        System.out.printf(reverseWords("the    sky is  blue "));
    }

    public String reverseWords(String s) {
        String[] stringArr = s.trim().split("\\s+");
        int L = 0;
        int R = stringArr.length-1;

        while (L < R) {
            String tmp = stringArr[L];
            stringArr[L] = stringArr[R];
            stringArr[R] = tmp;

            L++;
            R--;
        }
        return String.join(" ", stringArr);
    }
}
