package org.leetcode.tree;

import org.junit.jupiter.api.Test;

/**
 * #Array #BinarySearch
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 *  Time Complexity => O(LogN)
 *  https://leetcode.com/problems/search-insert-position/
 *  https://www.youtube.com/watch?v=K-RYzDZkzCI
 */
public class L35_SearchInsertPosition {

    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1,2,3,4,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 3));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length-1]) return nums.length;

        int left = 0;
        int right = nums.length-1;

        // when target is left == right
        // int midPoint = left + (right-left) / 2;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid == target) {
                return mid;
            }

            if(target > nums[mid])  // look right
            {
                left = mid + 1;
            }
            else                    // look left
            {
                right = mid-1;
            }
        }

        // why left => try with tc = [2], target=2|3
        return left;
    }

}
