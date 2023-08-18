package org.leetcode.easy.array;

import org.junit.jupiter.api.Test;

/**
 * #Array #TwoPointers #Swap
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * https://www.youtube.com/watch?v=DEJAZBq0FDA
 * https://www.youtube.com/watch?v=DEJAZBq0FDA => NeetCode
 *
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same. Then return the number of unique elements in num
 *
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 *
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 */
public class L26_RemoveDuplicatesFromSortedArray {

    @Test
    public void remove_duplicates_from_sorted_array() {
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }

    /**
     *                   R
     *                   L
     *  Input: nums = [0,0,1,1,1,2,2,3,3,4]
     *  Output: 5, nums = [0,1,2,3,4,2,2,3,4]
     *
     *
     *  1: 0, 0, 1, 1, 1, 2, 2, 3, 3, 4
     *  2: 0, 1, 0, 1, 1, 2, 2, 3, 3, 4
     *  3: 0, 1, 2, 1, 1, 1, 2, 3, 3, 4
     *
     */
    public static int removeDuplicates(int[] nums) {
        int L = 1;
        for (int R = 1; R < nums.length; R++) {
            // when you see unique value for first time swap
            if ( nums[R] != nums[R-1] ) {
                nums[L] = nums[R];
                L++;
            }
        }
        return L;
    }

}
