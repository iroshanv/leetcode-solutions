package org.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * #Array #TwoPointers
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 * https://www.youtube.com/watch?v=aayNRwUN3Do
 */
public class L283_MoveZeroes {


    @Test
    public void moveZeroesTest(){
        moveZeroes(new int[] {0 , 1, 0, 3, 12});
    }

    /**
     * using two pointer approach
     *
     *=>0 1 0 3 12
     *  1 0 0 3 12
     *  1 3 0 0 12
     *  1 3 12 0 0
     */
    public void moveZeroes(int[] nums) {

        for (int L = 0, R = 0;
             R < nums.length;
             R++) {

            if (nums[R] != 0) {
                swap(nums, R, L);
                L++;
            }

        }

        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int r, int l) {
        final int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
}
