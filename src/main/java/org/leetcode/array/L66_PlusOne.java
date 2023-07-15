package org.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * #Array #Math
 *
 * https://leetcode.com/problems/plus-one/
 *
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 * https://www.youtube.com/watch?v=G737jzcxG9A
 * https://www.youtube.com/watch?v=jIaA8boiG1s => NeetCode
 *
 */
public class L66_PlusOne {


    /**
     * 4 3 2 9
     *
     * 1st-loop 4 3 2 0
     * 2nd-loop 4 3 3 0 [output]
     *
     *
     * 9 9 9
     *
     * 1st-loop 9 9 0
     * 2nd-loop 9 0 0
     * 3rd-loop 0 0 0
     * 4th-loop 1 0 0 0
     *
     */
    @Test
    public void plusOne() {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }

    private static int[] plusOne(int[] digits) {
        int n = digits.length-1;

        for (int i = n; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }


    @Test
    public void plusOne_usingCarryTest() {
        System.out.println(Arrays.toString(plusOne_usingCarry(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne_usingCarry(new int[]{4,3,2,9})));
        System.out.println(Arrays.toString(plusOne_usingCarry(new int[]{9})));
        System.out.println(Arrays.toString(plusOne_usingCarry(new int[]{9,9,9})));
    }


    /**
     * https://www.youtube.com/watch?v=G737jzcxG9A
     *   4 3 2 1
     *   0 0 0 1
     *   -------
     * 0 4 3 2 2 (result)
     *
     *   4 3 2 9
     *   0 0 0 1
     *   -------
     * 0 4 3 4 0
     *
     *
     *  9
     *  1
     *  ----
     * 0 1 0
     */
    public static int[] plusOne_usingCarry(int[] digits) {
        int carry = 0;
        int length = digits.length;

        // will give something like e.g. 0 0 0 1
        int[] addOne = new int[length + 1];
        addOne[length-1] = 1;

        int[] result = new int[length];

        /**
         * 4329
         * 0001
         */
        for (int i = length; i > 0; i--) {

            int sum = addOne[i] + digits[i-1] + carry;
            int rem = sum % 10;
            carry = sum / 10;

            result[i] =  rem;
        }

        if (carry > 0){
            result[0] = 1;
        }

        return result;
    }

}
