package org.leetcode.medium.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self
 *
 * #Array #Prefix
 *
 */
public class L238_ProductOfArrayExceptSelf {


    @Test
    public void productExceptSelfTest() {
        System.out.printf(  toString( productExceptSelf(new int[]{1,2,3,4}) )  );
        System.out.printf(  toString( productExceptSelfPrefix(new int[]{1,2,3,4}) )  );
    }

    // BruteForce
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product = product * nums[j];
                    result[i] = product;
                }
            }
        }

        return result;
    }

    public static String toString(int[] array) {
        return Arrays.toString(array);
    }
    public int[] productExceptSelfPrefix(int[] nums) {

        int[] output = new int[nums.length];

        // create prefix array
        int prefix = 1;
        for (int i = 0; i < nums.length ; i++) {
            output[i] = prefix;
            prefix = prefix * nums[i];
        }

        // using postfix calculate final output
        int postfix = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            output[i] = postfix * output[i];
            postfix = postfix * nums[i];
        }

        return output;
    }
}
