package org.leetcode.medium.string;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.com/problems/string-compression/" />
 * <a href="https://leetcode.com/problems/string-compression/editorial/" />
 * <a href="https://www.youtube.com/watch?v=IhJgguNiYYk" />
 * Example 3:
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb".
 *
 * #TwoPointers #String
 */
public class L443_StringCompression {


    @Test
    public void stringCompressionTest() {
        System.out.println( compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}) ); // ["a","2","b","2","c","3"]
        System.out.println( compress(new char[]{'a', 'b', 'b','b','b','b', 'b','b','b','b','b','b','b','b','b'}) );
    }

    public int compress(char[] chars) {

        if (chars.length == 1) return 1;

        int index = 0;
        int L = 0;
        int R = 0;

        while (R < chars.length) {

            while (R < chars.length && chars[L] == chars[R]) {
                R++;
            }

            chars[index++] = chars[L];

            if (R - L > 1){
                String count = R - L + "";
                for(char c : count.toCharArray()){
                    chars[index++] = c;
                }
            }

            L = R;
        }

        return index;
    }
}
