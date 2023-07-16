package org.leetcode.tree;

import org.junit.jupiter.api.Test;

/**
 * #BinarySearchTree
 * https://leetcode.com/problems/binary-search/
 *
 * https://www.youtube.com/watch?v=9q0k3OyCKPY
 *
 * Given an array of integers nums which is sorted in ascending order,and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *                 0 1 2 3 4 5
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * https://www.youtube.com/watch?v=9q0k3OyCKPY
 */
public class L704_BinarySearch {

    // TODO: try using UpperBound and LowerBound

    @Test
    void binarySearchTest() {
        //5
        System.out.println(search(new int[]{5}, 5));

        // -1
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 6));

        // 4
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
    }

    public static int search(int[] nums, int target) {

        // set the left and right boundaries
        int left = 0;
        int right = nums.length-1;

        while (left <= right){
            // get the middle index and the middle value
            int mid = (left + right) / 2;

            // case-1 return the middle index
            if (nums[mid] == target) return mid;

            // case-2 discard the smaller half
            if (nums[mid] < target)
                left = mid + 1;
            // case-3 discard the larger half
            else if (nums[mid] > target)
                right = mid - 1;
        }
        // if we finish the search without finding target return -1
        return -1;
    }
}
