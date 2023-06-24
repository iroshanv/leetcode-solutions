package org.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * #Array #HashTable #Sorting
 *
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 *
 * https://www.youtube.com/watch?v=4oZsPXG9B94
 * https://www.youtube.com/watch?v=3OamzN90kPg => NeetCode
 *
 */
public class L217_ContainsDuplicate {


    @Test
    public void contains_duplicate_hashset_test() {
        System.out.println(containsDuplicate(new int[]{1,2,2,1}));
    }

    // time complexity
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numbers.contains(nums[i])) {
                return true;
            }
            numbers.add(nums[i]);
        }
        return false;
    }

    @Test
    public void contains_duplicate_sort_test() {
        System.out.println(containsDuplicate_sort(new int[]{1,2,2,1}));
    }

    /**
     * space complexity
     *
     * 1,4 2,3,3
     * sorted: 1 2 3 4 4
     */
    public static boolean containsDuplicate_sort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }

}
