package org.leetcode.easy.string;

import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reverse-vowels-of-a-string" />
 *
 * #TwoPointers #String
 */
public class L345_ReverseVowelsOfString {

    @Test
    public void reverseVowelsTest() {
        System.out.println(  reverseVowels("hello")  );
        System.out.println(  reverseVowels("leetcode")  );
    }

    public String reverseVowels(String s) {
        int L = 0;
        int R = s.length()-1;
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u','A','E','I','O','U');
        char[] chars = s.toCharArray();

        while (L < R) {
            if (vowels.contains(chars[L]) && vowels.contains(chars[R]) ) {
                swap(chars, L, R);
                L++;
                R--;
            }else {
                if (!vowels.contains(chars[L])) {
                    L++;
                }

                if (!vowels.contains(chars[R])) {
                    R--;
                }
           }
        }

        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
