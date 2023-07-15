package org.leetcode.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * #Array #TwoPointers #Sorting
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * https://www.youtube.com/watch?v=FPCZsG_AkUg => NeetCode
 * https://www.youtube.com/watch?v=PN68qx-Qkdw => NickWhite
 *
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 */
public class L977_SquaresOfSortedArray {


    // approach - 1
    @Test
    @DisplayName("using two pointers")
    public void squaresOfSortedArray_Test() {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    /**
     *
     * while(L_index <= R_index)
     *   if (result[first_item] > result[last_item])
     *      result[i] = first_item
     *   else
     *      result[i] = last_item
     */
    public static int[] sortedSquares(int[] nums) {

        if (nums.length == 0)
            return nums;

        int L = 0;
        int R = nums.length - 1;
        int i = nums.length - 1;
        int[] result = new int[nums.length];

        while (L <= R) {

            // insert elements from last
            if ( sqr(nums[L]) > sqr(nums[R]) ) {
                result[i] = sqr(nums[L]);
                L++;
            }else {
                result[i] = sqr(nums[R]);
                R--;
            }

            i--;
        }
        return result;
    }

    private static int sqr(int num) {
        return (int) Math.pow(num, 2);
    }


    // approach - 2
    @Test
    @DisplayName("Trivial approach")
    public void squaresOfSortedArray_Test_Trivial() {
        System.out.println(Arrays.toString(sortedSquares_trivial(new int[]{-4, -1, 0, 3, 10})));
    }

    public static int[] sortedSquares_trivial(int[] nums) {

        // square all elements in array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }

        // sort
        Arrays.sort(nums);
        return nums;
    }


    /*
     * Notes
     * other_approach: (this approach leads to messy code)
     *  1. take mid-element
     *  2. compare the adjacent values (L & R)
     *  3. add the lesser value to new array
     */
}
