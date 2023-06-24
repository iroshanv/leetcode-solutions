package org.leetcode.array;

import org.junit.jupiter.api.Test;

/**
 * #Array #Math #TwoPointers
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative
 * https://leetcode.com/problems/rotate-array/
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 *
 *
 * https://www.youtube.com/watch?v=gmu0RA5_zxs => NickWhite
 * https://www.youtube.com/watch?v=eXl0HBm2RrA => NeetCode
 *
 */
public class L189_RotateArray {


    @Test
    void rotate_array_test() {
        rotate(new int[]{1,2,3,4,5}, 10); // k is more
        rotate(new int[]{1,2,3}, 3);
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

    /**
     * https://www.youtube.com/watch?v=gmu0RA5_zxs
     *
     * original list : 1 2 3 4 5 6 7
     * rev all num   : 7 6 5 4 3 2 1
     * rev 1st k num : 5 6 7 4 3 2 1
     * rev n-k num   : 5 6 7 1 2 3 4  --> result
     *
     *
     */
    public static void rotate(int[] nums, int k) {
        // nums of array can be less than k, or equal to k, this avoids unnecessary rotations which do not change anything in array
        // avoid IndexOutOfBound
        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

}
